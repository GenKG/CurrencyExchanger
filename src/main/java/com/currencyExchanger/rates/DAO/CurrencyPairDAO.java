package com.currencyExchanger.rates.DAO;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class CurrencyPairDAO extends ControllerDAO<CurrencyPairDTO, Integer> {

    public static final String SELECT_ALL_CURRENCY_PAIR = "SELECT * FROM public.currency_pair";

    public static final String UPDATE_CURRENCY_PAIR_BY_ID = "UPDATE PUBLIC.Currency_Pair SET currency_base = ?, currency_counter = ?, date = ?, value = ? WHERE id = ?";

    public static final String GET_CURRENCY_PAIR_BY_ID = "SELECT * FROM PUBLIC.Currency_Pair WHERE id = ?";

    public static final String DELETE_CURRENCY_PAIR_BY_ID = "DELETE FROM PUBLIC.Currency_Pair  WHERE id = ? LIMIT 1";

    public static final String CREATE_CURRENCY_PAIR_BY_ID = "INSERT INTO PUBLIC.Currency_Pair (currency_base,currency_counter,date,values) VALUES (?,?,?,?)";

    public static final String SELECT_CURRENCY_PAIR_BY_DTO = "SELECT * FROM public.currency_pair WHERE currency_base = ? and currency_counter = ? and date = ? and value = ?";
    @Override
    public List<CurrencyPairDTO> getAll() {
        List<CurrencyPairDTO> listPairs = new LinkedList<>();
       PreparedStatement ps =  getPrepareStatement(SELECT_ALL_CURRENCY_PAIR);
       try {
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
            CurrencyPairDTO dto = new CurrencyPairDTO();
               dto.setCurrencyBase(Currency.valueOf(rs.getString(2)));
               dto.setCurrencyCounter(Currency.valueOf(rs.getString(3)));
               dto.setDate(rs.getDate(4));
               dto.setValue(rs.getDouble(5));
            listPairs.add(dto);
           }
       } catch (SQLException e){
           e.printStackTrace();
       } finally {
           closePrepareStatement(ps);
       }
       return listPairs;
    }

    @Override
    public boolean update(CurrencyPairDTO dto,Integer id) {
        PreparedStatement statement = getPrepareStatement(UPDATE_CURRENCY_PAIR_BY_ID);
        try {
            statement.setString(1, dto.getCurrencyBase().getDescription());
            statement.setString(2, dto.getCurrencyCounter().getDescription());
            statement.setDate(3, (Date) dto.getDate());
            statement.setDouble(4, dto.getValue());
            statement.setInt(5,id);
            int countChangesRows = statement.executeUpdate();
            System.out.println("Количество обновленных строк: " + countChangesRows);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
        return false;
    }

    @Override
    public CurrencyPairDTO getDTOById(Integer id) {
        PreparedStatement statement = getPrepareStatement(GET_CURRENCY_PAIR_BY_ID);
        CurrencyPairDTO dto = new CurrencyPairDTO();
        try {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dto.setCurrencyBase(Currency.valueOf(rs.getString(2)));
                dto.setCurrencyCounter(Currency.valueOf(rs.getString(3)));
                dto.setDate(rs.getDate(4));
                dto.setValue(rs.getDouble(5));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
        return dto;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement statement = getPrepareStatement(DELETE_CURRENCY_PAIR_BY_ID);
        try {
            statement.setInt(1, id);
            int countChangeQuery = statement.executeUpdate();
            System.out.println("Количество удаленных строк: " + countChangeQuery);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
        return false;
    }

    @Override
    public boolean create(CurrencyPairDTO dto) {
        PreparedStatement statement = getPrepareStatement(CREATE_CURRENCY_PAIR_BY_ID);
        try {
            statement.setString(1, dto.getCurrencyBase().getDescription());
            statement.setString(2, dto.getCurrencyCounter().getDescription());
            statement.setDate(3, new Date(dto.getDate().getTime()));
            statement.setDouble(4, dto.getValue());
            int countRows = statement.executeUpdate();
            System.out.println("Добавлено строк: " + countRows);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
        return false;
    }

    @Override
    public CurrencyPairDTO getDTOByDTO(CurrencyPairDTO dto) {
        PreparedStatement statement = getPrepareStatement(SELECT_CURRENCY_PAIR_BY_DTO);
        try {
            statement = getPrepareStatement(SELECT_CURRENCY_PAIR_BY_DTO);
            statement.setString(1,dto.getCurrencyBase().getDescription());
            statement.setString(2,dto.getCurrencyCounter().getDescription());
            statement.setDate(3, new Date(dto.getDate().getTime()));
            statement.setDouble(4,dto.getValue());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            dto.setCurrencyBase(Currency.valueOf(rs.getString(2)));
            dto.setCurrencyCounter(Currency.valueOf(rs.getString(3)));
            dto.setDate(rs.getDate(4));
            dto.setValue(rs.getDouble(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
        return dto;
    }
}
