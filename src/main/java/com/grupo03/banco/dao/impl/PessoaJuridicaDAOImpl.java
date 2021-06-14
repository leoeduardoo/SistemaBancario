package com.grupo03.banco.dao.impl;

import com.grupo03.banco.dao.PessoaJuridicaDAO;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.model.PessoaJuridica;
import com.grupo03.banco.utils.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaJuridicaDAOImpl implements PessoaJuridicaDAO {

    @Override
    public boolean save(PessoaJuridica pessoaJuridica) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idPessoa = -1;

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
                pstm = con.prepareStatement(INSERT_PESSOA, PreparedStatement.RETURN_GENERATED_KEYS);

                /*
                 * Os valores do objeto pessoa juridica são atribuídos
                 */

                pstm.setString(1, pessoaJuridica.getNome());
                pstm.setString(2, pessoaJuridica.getTelefone());
                pstm.setString(3, pessoaJuridica.getRua());
                pstm.setString(4, pessoaJuridica.getNumeroEndereco());
                pstm.setString(5, pessoaJuridica.getBairro());
                pstm.setString(6, pessoaJuridica.getCidade());
                pstm.setString(7, pessoaJuridica.getEstado());
                pstm.setString(8, pessoaJuridica.getDataNascimento());
                pstm.setString(9, pessoaJuridica.getSexo());

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
                    idPessoa = res.getLong(1);
                }

                /*
                 * O trecho abaixo permite a inserção de uma classe Juridica na tabela Juridica
                 */
                pstm = con.prepareStatement(INSERT_PESSOA_JURIDICA);

                pstm.setString(1, pessoaJuridica.getCnpj());
                pstm.setString(2, pessoaJuridica.getIe());
                pstm.setLong(3, idPessoa);
                pstm.executeUpdate();

                /*
                 * Abaixo segue as chamadas das outras classes DAO para persistência das
                 * outras classes em entidade no banco de dados.
                 */

//                AcessoDAO adao = new AcessoDAOImpl();
//                adao.save(con, fisica.getAcesso(), idPessoa);
//
//                EnderecoDAO edao = new EnderecoDAOImpl();
//                for (Endereco e : fisica.getEndereco()) {
//                    edao.save(con, e, idPessoa);
//                }

                /*
                 * Executando o commit da transação.
                 */
                con.commit();
                b = true;
                pessoaJuridica.setPessoa_id(idPessoa);
                pessoaJuridica.setId(idPessoa);
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
    }


    @Override
    public PessoaJuridica findByCnpj(String cnpj) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        PessoaJuridica pessoaJuridica = null;

        con = ConexaoMySQL.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_CNPJ);
                pstm.setString(1, cnpj);
                res = pstm.executeQuery();

                /**
                 * Recuperação o objeto
                 */
                while (res.next()) {
                    pessoaJuridica = new PessoaJuridica();

                    pessoaJuridica.setPessoa_id(res.getLong(1));
                    pessoaJuridica.setNome(res.getString(2));
                    pessoaJuridica.setTelefone(res.getString(3));
                    pessoaJuridica.setRua(res.getString(4));
                    pessoaJuridica.setNumeroEndereco(res.getString(5));
                    pessoaJuridica.setBairro(res.getString(6));
                    pessoaJuridica.setCidade(res.getString(7));
                    pessoaJuridica.setEstado(res.getString(8));
                    pessoaJuridica.setDataNascimento(res.getString(9));
                    pessoaJuridica.setSexo(res.getString(10));
                    pessoaJuridica.setCnpj(res.getString(11));
                    pessoaJuridica.setIe(res.getString(12));
                    pessoaJuridica.setId(res.getLong(1));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return pessoaJuridica;
    }

}