package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.ConnectionException;
import br.com.logusinfo.consultas.model.Node;

public class NodesRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public NodesRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Node> getNodes(String idConsulta) {
		List<Node> nodes = new ArrayList<Node>();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT\r\n"
					+ "    id_consulta,\r\n"
					+ "    id_eixo,\r\n"
					+ "    seq_no,\r\n"
					+ "    seq_no_sup,\r\n"
					+ "    id_nivel,\r\n"
					+ "    id_filtro,\r\n"
					+ "    id_medida,\r\n"
					+ "    id_estilo_cab,\r\n"
					+ "    id_estilo_cel,\r\n"
					+ "    cod_classificador,\r\n"
					+ "    tit_no,\r\n"
					+ "    num_decimais,\r\n"
					+ "    separador_milhar,\r\n"
					+ "    unid_monetaria,\r\n"
					+ "    exp_filtro,\r\n"
					+ "    func_agregacao,\r\n"
					+ "    prio_agregacao,\r\n"
					+ "    prio_formatacao,\r\n"
					+ "    disp_filhos,\r\n"
					+ "    iniciar_pagina,\r\n"
					+ "    ocultar,\r\n"
					+ "    tipo_corte,\r\n"
					+ "    tam_corte,\r\n"
					+ "    exp_corte\r\n"
					+ "FROM\r\n"
					+ "    "+esquemaOrigem+".fv_no_consulta\r\n"
					+ "WHERE \r\n"
					+ "    id_consulta = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idConsulta);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Node node = new Node();
				node.setIdConsulta(rs.getString(1));
				node.setIdEixo(rs.getString(2));
				node.setSeqNo(rs.getString(3));
				node.setSeqNoSup(rs.getString(4));
				node.setIdNivel(rs.getString(5));
				node.setIdFiltro(rs.getString(6));
				node.setIdMedida(rs.getString(7));
				node.setIdEstiloCab(rs.getString(8));
				node.setIdEstiloCel(rs.getString(9));
				node.setCodClassificador(rs.getString(10));
				node.setTitNo(rs.getString(11));
				node.setNumDecimais(rs.getString(12));
				node.setSeparadorMilhar(rs.getString(13));
				node.setUnidMonetaria(rs.getString(14));
				node.setExpFiltro(rs.getString(15));
				node.setFuncAgregacao(rs.getString(16));
				node.setPrioAgregacao(rs.getString(17));
				node.setPrioFormatacao(rs.getString(18));
				node.setDispFilhos(rs.getString(19));
				node.setIniciarPagina(rs.getString(20));
				node.setOcultar(rs.getString(21));
				node.setTipoCorte(rs.getString(22));
				node.setTamCorte(rs.getString(23));
				node.setExpCorte(rs.getString(24));
				nodes.add(node);
			}
		} catch (ConnectionException | SQLException e) {
			e.printStackTrace();
		}
		return nodes;
	}

}
