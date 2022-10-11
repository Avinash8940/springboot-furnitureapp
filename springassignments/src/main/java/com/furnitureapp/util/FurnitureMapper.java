package com.furnitureapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.furnitureapp.model.Furniture;

/**
 * @author AvinashSankineni
 *
 */
public class FurnitureMapper implements RowMapper<Furniture> {

	@Override
	public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Furniture furniture=new Furniture();
		furniture.setFurnitureId(rs.getInt("furnitureId"));
		furniture.setFurnitureName(rs.getString("FurnitureName"));
		furniture.setMaterial(rs.getString("material"));
		furniture.setType(rs.getString("type"));
		furniture.setCategory(rs.getString("category"));
		furniture.setShape(rs.getString("shape"));
		furniture.setPrice(rs.getDouble("price"));
		furniture.setQuantity(rs.getInt("quantity"));
		return furniture;
	}

}
