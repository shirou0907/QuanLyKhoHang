/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.model.NhanVien;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface NhanVienService {
    
    public List<NhanVien> getList();
    public int createOrUpdate(NhanVien nv);
}
