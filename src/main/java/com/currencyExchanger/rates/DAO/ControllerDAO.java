package com.currencyExchanger.rates.DAO;

import com.currencyExchanger.rates.Config.JDBCPostgreSQLConnect;
import com.currencyExchanger.rates.Model.CurrencyPair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class ControllerDAO<E,K> {

    private Connection connection;

    public ControllerDAO() {
        connection = JDBCPostgreSQLConnect.connection();
    }

    public abstract List<CurrencyPair> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

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
