package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.ConnectionException;
import br.com.logusinfo.consultas.model.Consulta;

public class ConsultasRepository {

	private Connection connection;

	private Statement statement;

	private StringBuilder sql;

	private String esquemaOrigem;

	public ConsultasRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Consulta> getConsultas() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		try {
			connection = ConnUtil.init();
			statement = connection.createStatement();
			sql = new StringBuilder();
			sql.append(" SELECT ID_CONSULTA,\r\n"
					+ "	 ID_CUBO, \r\n"
					+ "	 TIT_CONSULTA, \r\n"
					+ "	 DES_CONSULTA, \r\n"
					+ "	 TIP_VISUALIZACAO, \r\n"
					+ "	 EXP_FILTRO, \r\n"
					+ "	 COD_USUARIO, \r\n"
					+ "	 TIP_FILTRO_DADOS, \r\n"
					+ "	 CATEGORY_ID, \r\n"
					+ "	 IN_QUEBRA_HIERARQUIA_LINHAS, \r\n"
					+ "	 IN_QUEBRA_HIERARQUIA_COLUNAS, \r\n"
					+ "	 TIP_CORTE_LINHAS, \r\n"
					+ "	 TAM_CORTE_LINHAS, \r\n"
					+ "	 EXP_CORTE_LINHAS, \r\n"
					+ "	 TIP_CORTE_COLUNAS, \r\n"
					+ "	 TAM_CORTE_COLUNAS, \r\n"
					+ "	 EXP_CORTE_COLUNAS, \r\n"
					+ "	 TIP_ORIENTACAO, \r\n"
					+ "	 TAM_LARGURA_GRAFICO, \r\n"
					+ "	 TAM_ALTURA_GRAFICO, \r\n"
					+ "	 TIP_GRAFICO, \r\n"
					+ "	 TIP_GRAFICO_3D, \r\n"
					+ "	 MESCLAR_CEL_EIXO_Y, \r\n"
					+ "	 USAR_TIT_CUSTOM_EIXO_Y, \r\n"
					+ "	 TIT_CUSTOM_EIXO_Y, \r\n"
					+ "	 VAZIO_LUGAR_ZERO, \r\n"
					+ "	 REPETIR_HEADER_PAG, \r\n"
					+ "	 COD_HEADER, \r\n"
					+ "	 COD_FOOTER, \r\n"
					+ "	 IN_SQL_ANSI, \r\n"
					+ "	 IN_FORCA_ONLINE, \r\n"
					+ "	 CONGELAR_CEL_EIXO_Y, \r\n"
					+ "	 IN_PERMITE_ONLINE ");
			sql.append(" FROM "+esquemaOrigem+".FV_CONSULTA ");
			sql.append(" WHERE ID_CONSULTA > '008000' ");
			sql.append(" ORDER BY ID_CONSULTA DESC");
			ResultSet rs = statement.executeQuery(sql.toString());
			while (rs.next()) {
				Consulta consulta = new Consulta();			
				consulta.setIdConsulta(rs.getString(1));
				consulta.setIdCubo(rs.getString(2));
				consulta.setTituloConsulta(rs.getString(3));
				consulta.setDesConsulta(rs.getString(4));
				consulta.setTipVisualizacao(rs.getString(5));
				consulta.setExpFiltro(rs.getString(6));
				consulta.setCodUsuario(rs.getString(7));
				consulta.setTipoFiltroDados(rs.getString(8));
				consulta.setIdCategory(rs.getString(9));
				consulta.setIndicadorQuebraHierarquiaLinhas(rs.getString(10));
				consulta.setIndicadorQuebraHierarquiaColunas(rs.getString(11));
				consulta.setTipoCorteLinhas(rs.getString(12));
				consulta.setTamanhoCorteLinhas(rs.getString(13));
				consulta.setExpressaoCorteLinhas(rs.getString(14));
				consulta.setTipoCorteColunas(rs.getString(15));
				consulta.setTamanhoCorteColunas(rs.getString(16));
				consulta.setExpressaoCorteColunas(rs.getString(17));
				consulta.setTipoOrientacao(rs.getString(18));
				consulta.setTamanhoLarguraGrafico(rs.getString(19));
				consulta.setTamanhoAlturaGrafico(rs.getString(20));
				consulta.setTipoGrafico(rs.getString(21));
				consulta.setTipoGrafico3D(rs.getString(22));
				consulta.setMerclarCelEixoY(rs.getString(23));
				consulta.setUsarTitCustomEixoY(rs.getString(24));
				consulta.setTituloCustomEixoY(rs.getString(25));
				consulta.setVazioLugarZero(rs.getString(26));
				consulta.setRepetirHeaderPag(rs.getString(27));
				consulta.setCodHeader(rs.getString(28));
				consulta.setCodFooter(rs.getString(29));
				consulta.setIndicadorSQLANSI(rs.getString(30));
				consulta.setIndicadorForcaOnline(rs.getString(31));
				consulta.setCongelarCelularEixoY(rs.getString(32));
				consulta.setIndicadorPermiteOnline(rs.getString(33));
				consultas.add(consulta);
			}
		} catch (ConnectionException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return consultas;
	}

}
