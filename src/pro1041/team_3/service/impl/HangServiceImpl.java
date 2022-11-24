/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro1041.team_3.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.var;
import pro1041.team_3.domainModel.Hang;
import pro1041.team_3.dto.ChiTietDienThoaiDto;
import pro1041.team_3.dto.HangDto;
import pro1041.team_3.repository.HangRepository;
import pro1041.team_3.service.IHangService;

/**
 *
 * @author Admin
 */
public class HangServiceImpl implements IHangService {

    private HangRepository hangRepository;
    private ArrayList<HangDto> _lstHang;

    public HangServiceImpl() {
        hangRepository = new HangRepository();
        _lstHang = new ArrayList<>();
    }

    @Override
    public ArrayList<HangDto> getAll() {
        _lstHang = new ArrayList<>();
        List<Hang> listHang = hangRepository.getAll();
        for (Hang x : listHang) {
            _lstHang.add(new HangDto(x.getId(), x.getMa(), x.getTen()));
        }
        return _lstHang;

    }

    @Override
    public String insert(Hang hangResponse) {
        hangResponse.setId(null);
        if (hangResponse.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (!hangResponse.getMa().matches("^(H)\\d{5}$")) {
            return "Mã không đúng định dạng";
        }
        if (hangResponse.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        Hang hangDT = hangRepository.findByMa(hangResponse.getMa());
        if (hangDT != null) {
            return "Mã không được trùng";
        }
        hangResponse = hangRepository.saveOrUpdate(hangResponse);
        if (hangResponse != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        Hang hangDT = hangRepository.findById(id);
        ChiTietDienThoaiDto chiTietDienThoaiDto = hangRepository.checkHangTrongCtdt(id);
        if (hangDT == null) {
            return "Không tìm thấy";
        }
        if (chiTietDienThoaiDto != null) {
            return "Hãng đã tồn tại trong bảng điện thoại";
        }
        boolean delete = hangRepository.detele(hangDT);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(Hang hangResponse) {
        Hang hangByID = hangRepository.findById(hangResponse.getId());
        if (hangByID == null) {
            return "Không tìm thấy";
        }
        if (hangResponse.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (!hangResponse.getMa().matches("^(H)\\d{5}$")) {
            return "Mã không đúng định dạng";
        }
        if (hangResponse.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }

        if (!hangResponse.getMa().equals(hangByID.getMa())) {
            Hang hangByMa = hangRepository.findByMa(hangResponse.getMa());
            if (hangByMa != null) {
                return "Mã không được trùng";
            } else {
                hangByID.setMa(hangResponse.getMa());
            }
        }
        hangByID.setTen(hangResponse.getTen());
        hangResponse = hangRepository.saveOrUpdate(hangByID);
        if (hangResponse != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<HangDto> findHang(String ten) {
        _lstHang = new ArrayList<>();
        List<Hang> listHang = hangRepository.findHang(ten);
        for (Hang x : listHang) {
            _lstHang.add(new HangDto(x.getId(), x.getMa(), x.getTen()));
        }
        return _lstHang;
    }

}
