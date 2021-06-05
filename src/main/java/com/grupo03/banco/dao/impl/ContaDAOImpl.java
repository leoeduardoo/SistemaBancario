package com.grupo03.banco.dao.impl;

import com.grupo03.banco.dao.ContaDAO;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.utils.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAOImpl implements ContaDAO {

    @Override
    public boolean save(Conta conta, String fk) throws SQLException {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idConta = -1;

        con = ConexaoMySQL.getConexao();

        if (con != null) {
            try {
                /*
                 * Setando a conexão para falso, que representa o start da transação
                 */
                con.setAutoCommit(false);

                /*
                 * Essa instrução recebe o comando SQL (INSERT_PESSOA) e uma flag
                 * (PreparedStatement.RETURN_GENERATED_KEYS) que determina que a chave
                 * da entidade perisistida deve ser retornada
                 */
                pstm = con.prepareStatement(INSERT_CONTA, PreparedStatement.RETURN_GENERATED_KEYS);

                /*
                 * Os valores do objeto conta são atribuídos
                 */

                pstm.setBigDecimal(1, conta.getSaldo());
                pstm.setString(2, conta.getNumero());
                pstm.setString(3, conta.getDataAberturaConta());
                pstm.setString(4, conta.getTipoConta());
                pstm.setString(5, fk);

                /*
                 * Esse comando executa a instrução SQL
                 */
                pstm.executeUpdate();

                /*
                 * Esse comando retorna um objeto do tipo ResultSet contendo a chave gerada.
                 */
                res = pstm.getGeneratedKeys();

                /**
                 * Recuperação da chave gerada
                 */
                while (res.next()) {
                    idConta = res.getLong(1);
                }

                /*
                 * Executando o commit da transação.
                 */
                con.commit();
                b = true;
                conta.setPessoa_id(idConta);
                conta.setId(idConta);
            } catch (SQLException ex) {
                throw new SQLException(this.getClass().getName() + " - Problemas no PreparedStatement!\n" + ex.getMessage());
            }
        }

        return b;
    }

    @Override
    public Conta findByIdPessoa(String idPessoa) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Conta conta = null;

        con = ConexaoMySQL.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_ID_PESSOA);
                pstm.setString(1, idPessoa);
                res = pstm.executeQuery();

                while (res.next()) {
                    conta = new Conta();
                    conta.setId(res.getLong(1));
                    conta.setSaldo(res.getBigDecimal(2));
                    conta.setNumero(res.getString(3));
                    conta.setDataAberturaConta(res.getString(4));
                    conta.setTipoConta(res.getString(5));
                    conta.setPessoa_id(Long.parseLong(idPessoa));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return conta;
    }

}