package br.com.logusinfo.consultas.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.model.Cubo;
import br.com.logusinfo.consultas.model.Dimensao;
import br.com.logusinfo.consultas.model.Filtro;
import br.com.logusinfo.consultas.model.Hierarquia;
import br.com.logusinfo.consultas.model.Medida;
import br.com.logusinfo.consultas.model.Nivel;
import br.com.logusinfo.consultas.model.NivelHierarquia;
import br.com.logusinfo.consultas.model.Node;
import br.com.logusinfo.consultas.model.Propriedade;

public class ScriptsService {

	private String esquemaDestino;
	private Map<String, String> mapaPropriedade = new HashMap<>();

	public ScriptsService(String esquemaDestino) {
		this.esquemaDestino = esquemaDestino;
	}
	
    public Map<String, String> getMapaPropriedade() {
      return mapaPropriedade;
    }

    public void setMapaPropriedade(Map<String, String> mapaPropriedade) {
      this.mapaPropriedade = mapaPropriedade;
    }

	public StringBuilder generate(StringBuilder scriptDML, Consulta consulta) {
		Set<String> jahEscritos = new HashSet<String>();
		Cubo cubo = consulta.getCubo();
		List<Nivel> niveis = cubo.getNiveis();
		List<Dimensao> dimensoes = new ArrayList<>();
		String chave = "";
		for (Nivel nivel : niveis) {
			Dimensao dimensao = nivel.getDimensao();
			if(null!=dimensao && !dimensao.getTitulo().isBlank()) {
				scriptDML.append("--DIMENSAO-----------------\n");
				chave = dimensao.getClass().getTypeName()+dimensao.getId();
				if(!jahEscritos.contains(chave)) {
					scriptDML.append(dimensao.DML(esquemaDestino)+"\n");
					jahEscritos.add(chave);
				}
				scriptDML.append("--------------------------\n");
				dimensoes.add(dimensao);
			}
			scriptDML.append("--NIVEL--------------------\n");
			chave = nivel.getClass().getTypeName()+nivel.getIdNivel();
			if(!jahEscritos.contains(chave)) {
				scriptDML.append(nivel.DML(esquemaDestino)+"\n");
				jahEscritos.add(chave);
			}
			scriptDML.append("--------------------------\n");
		}
		scriptDML.append("--CUBO--------------------\n");
		chave = cubo.getClass().getTypeName()+cubo.getId();
		if(!jahEscritos.contains(chave)) {
			scriptDML.append(cubo.DML(esquemaDestino)+"\n");
			jahEscritos.add(chave);
		}
		scriptDML.append("--------------------------\n");
		scriptDML.append("--CONSULTA-----------------\n");
		chave = consulta.getClass().getTypeName()+consulta.getIdConsulta();
		if(!jahEscritos.contains(chave)) {
			scriptDML.append(consulta.DML(esquemaDestino)+"\n");
			jahEscritos.add(chave);
		}
		scriptDML.append("--------------------------\n");
		List<Node> nodes = consulta.getNodes();
		for (Node node : nodes) {
			Nivel nivel = node.getNivel();
			if(null != nivel && !nivel.getTitulo().isBlank()) {
				Dimensao dimensao = nivel.getDimensao();
				if(null != dimensao && null!=dimensao.getTitulo() && !dimensao.getTitulo().isBlank()) {		
					scriptDML.append("--DIMENSAO-----------------\n");
					chave = dimensao.getClass().getTypeName()+dimensao.getId();
					if(!jahEscritos.contains(chave)) {
						scriptDML.append(dimensao.DML(esquemaDestino)+"\n");
						jahEscritos.add(chave);
					}
					scriptDML.append("--------------------------\n");
					scriptDML.append("--NIVEL--------------------\n");
					chave = nivel.getClass().getTypeName()+nivel.getIdNivel();
					if(!jahEscritos.contains(chave)) {
						scriptDML.append(nivel.DML(esquemaDestino)+"\n");
						jahEscritos.add(chave);
					}
					scriptDML.append("--------------------------\n");
				}
			}
			Filtro filtro = node.getFiltro();
			if(null != filtro && null!=filtro.getTituloFiltro() && !filtro.getTituloFiltro().isBlank()) {
				scriptDML.append("--FILTRO-------------------\n");
				chave = filtro.getClass().getTypeName()+filtro.getId();
				if(!jahEscritos.contains(chave)) {
					scriptDML.append(filtro.DML(esquemaDestino)+"\n");
					jahEscritos.add(chave);
				}
				scriptDML.append("--------------------------\n");
			}
			Medida medida = node.getMedida();
			if(null != medida && null!=medida.getTituloMedida() && !medida.getTituloMedida().isBlank()) {
				scriptDML.append("--MEDIDA-------------------\n");
				chave = medida.getClass().getTypeName()+medida.getId();
				if(!jahEscritos.contains(chave)) {
					scriptDML.append(medida.DML(esquemaDestino)+"\n");
					jahEscritos.add(chave);
				}
				scriptDML.append("--------------------------\n");
			}
			scriptDML.append("--NODE-------------------\n");
			
			chave = node.getClass().getTypeName()+node.getIdConsulta()+node.getIdEixo()+node.getSeqNo();
			if(!jahEscritos.contains(chave)) {
				scriptDML.append(node.DML(esquemaDestino)+"\n");
				jahEscritos.add(chave);
			}
			scriptDML.append("--------------------------\n");
			
		}
		
		List<Medida> medidasCubo = cubo.getMedidasCubo();
		for (Medida medida : medidasCubo) {
		  medida.setCubo(cubo);
          if(null != medida && null!=medida.getTituloMedida() && !medida.getTituloMedida().isBlank()) {
            scriptDML.append("--MEDIDA-------------------\n");
            chave = medida.getClass().getTypeName()+medida.getId();
            if(!jahEscritos.contains(chave)) {
                scriptDML.append(medida.DML(esquemaDestino)+"\n");
                jahEscritos.add(chave);
            }
            scriptDML.append("--------------------------\n");
          }
		}
		
		for (Dimensao dimensao : dimensoes) {
		  List<Hierarquia> hierarquias = dimensao.getHierarquias();
		  for (Hierarquia hierarquia : hierarquias) {
            if(null != hierarquia && null!=hierarquia.getTitulo() && !hierarquia.getTitulo().isBlank()) {             
              chave = hierarquia.getClass().getTypeName()+hierarquia.getId();
              if(!jahEscritos.contains(chave)) {
                  scriptDML.append("--Hierarquia-------------------\n");
                  scriptDML.append(hierarquia.DML(esquemaDestino)+"\n");
                  jahEscritos.add(chave);
                  scriptDML.append("--------------------------\n");
              }
              }
		  }
		}
		
		
		List<Propriedade> propriedades = consulta.getPropriedades();
		
		String proximoIdStr = obterProximoIdPropriedade();
		int proximoId = Integer.parseInt(proximoIdStr);
		
		for (Propriedade propriedade : propriedades) {
		    String idFormatado = String.format("%06d", proximoId);
			Nivel nivel = propriedade.getNivel();
			Dimensao dimensao = nivel.getDimensao();
			this.mapaPropriedade.put(propriedade.getId(), idFormatado);
			
			chave = dimensao.getClass().getTypeName()+dimensao.getId();
			if(!jahEscritos.contains(chave)) {
				scriptDML.append(dimensao.DML(esquemaDestino)+"\n");
				jahEscritos.add(chave);
			}
			chave = nivel.getClass().getTypeName()+nivel.getIdNivel();
			if(!jahEscritos.contains(chave)) {
				scriptDML.append(nivel.DML(esquemaDestino)+"\n");
				jahEscritos.add(chave);
			}
			chave = propriedade.getClass().getTypeName()+propriedade.getId();
			if(!jahEscritos.contains(chave)) {
				scriptDML.append(propriedade.DML(esquemaDestino, idFormatado)+"\n");
				jahEscritos.add(chave);
			}
			 proximoId++;
		}
		
		consulta.getCubo().getVisibilidades().stream().forEach(
				visibilidade->{
					scriptDML.append(visibilidade.DML(esquemaDestino)+"\n");
				});
		consulta.getCompartilhamentos().stream().forEach(
				compartilhamento->{
					scriptDML.append(compartilhamento.DML(esquemaDestino)+"\n");
				});
		
		String substituido = substituirIdsPropriedade(scriptDML.toString(), mapaPropriedade);
		scriptDML.setLength(0); // limpa o conteúdo atual
		scriptDML.append(substituido); // adiciona o texto com substituições
		return scriptDML;

	}
	
	public String obterProximoIdPropriedade() {
	    String sql = "SELECT LPAD(TO_CHAR(COALESCE(MAX(TO_NUMBER(ID_PROPRIEDADE)), 0) + 1), 6, '0') AS proximo_id FROM "
	            + esquemaDestino + ".PROPRIEDADE";

	    try (Connection conn = ConnUtil.init();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            return rs.getString("proximo_id"); // já com zeros à esquerda
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erro ao buscar próximo ID_PROPRIEDADE", e);
	    }
	    return null;
	}
	
	public String substituirIdsPropriedade(String scriptCompleto, Map<String, String> mapaPropriedade) {
	    Pattern pattern = Pattern.compile("<P>(\\d{6})</P>");
	    Matcher matcher = pattern.matcher(scriptCompleto);
	    StringBuffer resultado = new StringBuffer();

	    while (matcher.find()) {
	        String idAntigo = matcher.group(1);
	        String idNovo = mapaPropriedade.get(idAntigo);
	        if (idNovo != null) {
	            matcher.appendReplacement(resultado, "<P>" + idNovo + "</P>");
	        } else {
	            matcher.appendReplacement(resultado, "<P>" + idAntigo + "</P>");
	        }
	    }

	    matcher.appendTail(resultado);
	    return resultado.toString();
	}




}
