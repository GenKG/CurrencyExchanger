package com.currencyExchanger.rates.DAO;

import com.currencyExchanger.rates.Config.JDBCPostgreSQLConnect;
import com.currencyExchanger.rates.DTO.CurrencyPairDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class ControllerDAO<E,K> {

    private Connection connection;

    public ControllerDAO() {
        connection = JDBCPostgreSQLConnect.connection();
    }

    public abstract List<CurrencyPairDTO> getAll();
    public abstract boolean update(E entity,K id);
    public abstract E getDTOById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);
    public abstract E getDTOByDTO(E entity);

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
