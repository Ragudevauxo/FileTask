package com.letsstartcoding.springbootrestapiexmaple.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexmaple.dao.DepartmentDAO;
import com.letsstartcoding.springbootrestapiexmaple.model.Department;

@RestController
@RequestMapping("/task1")
public class DepartmentController {
	
	@Autowired
	DepartmentDAO departmentDAO;
	
	/* to save an department*/
	@PostMapping("/department")
	public Department createEmployee(@Valid @RequestBody Department dprt) {
		return departmentDAO.save(dprt);
	}
	
	/* get all departments*/
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		return departmentDAO.findAll();
	}
	/*get department by dprtid*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(value="id") Long dprtid){
		Department dprt = departmentDAO.findOne(dprtid);
		
		if(dprt==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dprt);
	}
	
	/*update an department by dprtid*/
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value="id") Long dprtid,@Valid @RequestBody Department dprtDetails){
		
		Department dprt = departmentDAO.findOne(dprtid);
		if(dprt==null) {
			return ResponseEntity.notFound().build();
		}
		dprt.setDprtid(dprtDetails.getDprtid());
	
		
		
		Department updateDepartment=departmentDAO.save(dprt);
		return ResponseEntity.ok().body(updateDepartment);
		
	}
	/*Delete an department*/
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<Department> deleteEmployee(@PathVariable(value="id") Long dprtid){
		Department dprt = departmentDAO.findOne(dprtid);
		if(dprt==null) {
			return ResponseEntity.notFound().build();
		}
		
		departmentDAO.delete(dprt);
		return ResponseEntity.ok().build();
	}
}

