package com.grupo03.banco.service.impl;

import com.grupo03.banco.dao.ContaDAO;
import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.response.RelacaoContasResponse;
import com.grupo03.banco.service.ContaService;
import com.grupo03.banco.utils.DaoFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    private ContaDAO contaDAO;

    public ContaServiceImpl() {
        this.contaDAO = DaoFactory.getContaDAO();
    }

    @Override
    public boolean update(Conta entity) throws SQLException {
        boolean b = false;

        if (entity != null) {
            b = this.contaDAO.update(entity);
        }

        return b;
    }

    @Override
    public boolean save(Conta entity, String fk) throws SQLException {
        boolean b = false;

        if (entity != null) {
            b = this.contaDAO.save(entity, fk);
        }

        return b;
    }

    @Override
    public Conta findByIdPessoa(String idPessoa) throws SQLException {
        return this.contaDAO.findByIdPessoa(idPessoa);
    }

    @Override
    public Conta findByNumero(String numero) throws SQLException {
        return this.contaDAO.findByNumero(numero);
    }

    @Override
    public List<RelacaoContasResponse> findAllJoinPessoa() throws SQLException {
        return this.contaDAO.findAllJoinPessoa();
    }

}