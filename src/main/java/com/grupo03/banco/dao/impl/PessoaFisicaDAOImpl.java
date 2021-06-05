package com.grupo03.banco.dao.impl;

import com.grupo03.banco.dao.PessoaFisicaDAO;
import com.grupo03.banco.model.PessoaFisica;
import com.grupo03.banco.utils.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaFisicaDAOImpl implements PessoaFisicaDAO {

    @Override
    public boolean save(PessoaFisica pessoaFisica) {
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
                 * O valor do objeto fisica é atribuído ao primeiro parâmetro do comando SQL
                 */

                pstm.setString(1, pessoaFisica.getNome());
                pstm.setString(2, pessoaFisica.getTelefone());
                pstm.setString(3, pessoaFisica.getRua());
                pstm.setString(4, pessoaFisica.getNumeroEndereco());
                pstm.setString(5, pessoaFisica.getBairro());
                pstm.setString(6, pessoaFisica.getCidade());
                pstm.setString(7, pessoaFisica.getEstado());
                pstm.setString(8, pessoaFisica.getDataNascimento());
                pstm.setString(9, pessoaFisica.getSexo());

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
                 * O trecho abaixo permite a inserção de uma classe Fisica na tabela Fisica
                 */
                pstm = con.prepareStatement(INSERT_PESSOA_FISICA);

                pstm.setString(1, pessoaFisica.getCpf());
                pstm.setString(2, pessoaFisica.getRg());
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
                pessoaFisica.setPessoa_id(idPessoa);
                pessoaFisica.setId(idPessoa);
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
    }


    @Override
    public PessoaFisica findByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        PessoaFisica pessoaFisica = null;

        con = ConexaoMySQL.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_NOME);
                pstm.setString(1, nome);
                res = pstm.executeQuery();

                /**
                 * Recuperação o objeto
                 */
                while (res.next()) {
                    pessoaFisica = new PessoaFisica();

                    pessoaFisica.setPessoa_id(res.getLong(1));
                    pessoaFisica.setNome(res.getString(2));
                    pessoaFisica.setTelefone(res.getString(3));
                    pessoaFisica.setRua(res.getString(4));
                    pessoaFisica.setNumeroEndereco(res.getString(5));
                    pessoaFisica.setBairro(res.getString(6));
                    pessoaFisica.setCidade(res.getString(7));
                    pessoaFisica.setEstado(res.getString(8));
                    pessoaFisica.setDataNascimento(res.getString(9));
                    pessoaFisica.setSexo(res.getString(10));
                    pessoaFisica.setCpf(res.getString(11));
                    pessoaFisica.setRg(res.getString(12));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return pessoaFisica;
    }

}