package com.furnitureapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.Furniture;
import com.furnitureapp.util.FurnitureMapper;
import com.furnitureapp.util.IRowMapper;
import com.furnitureapp.util.Queries;

/**
 * @author AvinashSankineni
 *
 */
@Repository
public class FurnitureDaoImpl implements IFurnitureDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addFurniture(Furniture furniture) {
			Object[] furnitureArray= { furniture.getFurnitureName(),furniture.getMaterial(),furniture.getType(),furniture.getCategory(),furniture.getShape(),furniture.getPrice(),furniture.getQuantity()};
		jdbcTemplate.update(Queries.ADDQUERY,furnitureArray);
	}

	@Override
	public int updateFurniture(int furnitureId, double price) {
		int result=jdbcTemplate.update(Queries.UPDATEQUERY,price,furnitureId);
		return result;
	}

	@Override
	public int deleteFurniture(int furnitureId) {
		int result=jdbcTemplate.update(Queries.DELETEQUERY,furnitureId);
		return result;
	}

	@Override
	public Furniture findById(int furnitureId) {
		Furniture nFurniture=jdbcTemplate.queryForObject(Queries.QUERYBYID,(rs,rowNum)->{
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
		},furnitureId);
		return nFurniture;
		
	}

	@Override
	public List<Furniture> findAllFurnitures() {
		RowMapper<Furniture> mapper=new FurnitureMapper();
		List<Furniture> furnitures=jdbcTemplate.query(Queries.QUERYALL,mapper);
		return furnitures;
	}

	@Override
	public List<Furniture> findByCategory(String category) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYCATEGORY, new FurnitureMapper(),category);
		
	}

	@Override
	public List<Furniture> findByType(String type) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYTYPE, new FurnitureMapper(),type);
	}

	@Override
	public List<Furniture> findByCategoryAndType(String category, String type) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYCATEGORYANDTYPE, new FurnitureMapper(),category,type);
	}

	@Override
	public List<Furniture> findByNameAndShape(String furnitureName, String shape) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYNAMEANDSHAPE, new FurnitureMapper(),furnitureName,shape);
	}

	@Override
	public List<Furniture> findByNameAndMaterial(String furnitureName, String material) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYNAMEANDMATERIAL, new FurnitureMapper(),furnitureName,material);
	}

	@Override
	public List<Furniture> findByNameAndPrice(String furnitureName, double price) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYNAMEANDPRICE, new FurnitureMapper(),furnitureName,price);
	}

	@Override
	public List<Furniture> findByNameAndCategory(String furnitureName, String category) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYNAMEANDCATEGORY, new FurnitureMapper(),furnitureName,category);
	}
}
	