package pro1041.team_3.service.impl;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import lombok.var;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pro1041.team_3.domainModel.KhachHang;
import pro1041.team_3.dto.KhachHangDto;
import pro1041.team_3.repository.KhachHangRepository;
import pro1041.team_3.service.KhachHangService;

/**
 *
 * @author hanhltph27725
 */
public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khachHangRepository;
    private ArrayList<KhachHangDto> _lstKhachHang;

    public KhachHangServiceImpl() {
        khachHangRepository = new KhachHangRepository();
        _lstKhachHang = new ArrayList<>();
    }

    @Override
    public ArrayList<KhachHangDto> getAll() {
        _lstKhachHang = new ArrayList<>();
        List<KhachHang> listKh = khachHangRepository.getAllOrderBy();
        for (KhachHang x : listKh) {
            _lstKhachHang.add(new KhachHangDto(x.getId(), x.getMa(), x.getHoTen(), new java.sql.Date(x.getNgaySinh().getTime()),
                    x.getGioiTinh(), x.getSdt(), x.getDiaChi(), x.getEmail()));
        }
        return _lstKhachHang;
    }

    @Override
    public String insert(KhachHang khachHang) {
        khachHang.setId(null);
        KhachHang findSDT = khachHangRepository.findSDT(khachHang.getSdt());
        KhachHang findEmail = khachHangRepository.findEmail(khachHang.getEmail());
        LocalDateTime time = LocalDateTime.now();
        long maMax = khachHangRepository.getMaOrderBy();
        String maKH = "KH0" + ++maMax;
        System.out.println(maKH);
        khachHang.setMa(maKH);
        if (khachHang.getHoTen().trim().isEmpty()) {
            return "H??? t??n kh??ng ???????c tr???ng";
        }
        if (khachHang.getHoTen().length() > 100) {
            return "H??? t??n kh??ng qu?? 100 k?? t???";
        }
        if (khachHang.getSdt().trim().isEmpty()) {
            return "S??T kh??ng ???????c tr???ng";
        }
        if (findSDT != null) {
            return "S??T kh??ng ???????c tr??ng";
        }
        if (!khachHang.getSdt().matches("^\\d+$")) {
            return "S??T ph???i l?? s???";
        }
        if (khachHang.getSdt().length() > 20) {
            return "S??? ??i???n tho???i t???i thi???u 20 s???";
        }
        if (khachHang.getEmail().trim().isEmpty()) {
            return "Email kh??ng ???????c tr???ng";
        }
        if (khachHang.getEmail().length() > 100) {
            return "Email kh??ng qu?? 100 k?? t???";
        }
        if (findEmail != null) {
            return "Email kh??ng ???????c tr??ng";
        }
        if (!khachHang.getEmail().matches("^\\S+@\\S+$")) {
            return "Email kh??ng ????ng ?????nh d???ng";
        }
        khachHang = khachHangRepository.saveOrUpdate(khachHang);
        if (khachHang != null) {
            return "Th??m th??nh c??ng";
        } else {
            return "Th??m th???t b???i";
        }
    }

    @Override
    public String delete(UUID id) {
        KhachHang khachHangFind = khachHangRepository.findById(id);
        if (khachHangFind == null) {
            return "Kh??ng t??m th???y";
        }
        boolean delete = khachHangRepository.detele(khachHangFind);
        if (delete) {
            return "X??a th??nh c??ng";
        } else {
            return "X??a th???t b???i";
        }
    }

    @Override
    public String update(KhachHang khachHang) {
        KhachHang khachHangFindById = khachHangRepository.findByMa(khachHang.getMa());
        KhachHang findSDT = khachHangRepository.findSDT(khachHang.getSdt());
        KhachHang findEmail = khachHangRepository.findEmail(khachHang.getEmail());
        if (khachHangFindById == null) {
            return "Kh??ng t??m th???y";
        }
        if (khachHang.getHoTen().trim().isEmpty()) {
            return "H??? t??n kh??ng ???????c tr???ng";
        }
        if (khachHang.getHoTen().length() > 100) {
            return "H??? t??n kh??ng qu?? 100 k?? t???";
        }
        if (khachHang.getSdt().trim().isEmpty()) {
            return "S??T kh??ng ???????c tr???ng";
        }
        if (!khachHang.getSdt().equals(khachHangFindById.getSdt())) {
            if (findSDT != null) {
                return "S??T kh??ng ???????c tr??ng";
            } else {
                khachHangFindById.setSdt(khachHang.getSdt());
            }
        }
        if (!khachHang.getSdt().matches("^\\d+$")) {
            return "S??T ph???i l?? s???";
        }
        if (khachHang.getSdt().length() > 20) {
            return "S??? ??i???n tho???i t???i thi???u 20 s???";
        }
        if (khachHang.getEmail().trim().isEmpty()) {
            return "Email kh??ng ???????c tr???ng";
        }
        if (khachHang.getEmail().length() > 100) {
            return "Email kh??ng qu?? 100 k?? t???";
        }
        if (!khachHang.getEmail().equals(khachHangFindById.getEmail())) {
            if (findEmail != null) {
                return "Email kh??ng ???????c tr??ng";
            } else {
                khachHangFindById.setEmail(khachHang.getEmail());
            }
        }
        if (!khachHang.getEmail().matches("^\\S+@\\S+$")) {
            return "Email kh??ng ????ng ?????nh d???ng";
        }
        khachHangFindById.setHoTen(khachHang.getHoTen());
        khachHangFindById.setNgaySinh(khachHang.getNgaySinh());
        khachHangFindById.setDiaChi(khachHang.getDiaChi());
        khachHangFindById.setGioiTinh(khachHang.getGioiTinh());
        khachHang = khachHangRepository.saveOrUpdate(khachHangFindById);
        if (khachHang != null) {
            return "S???a th??nh c??ng";
        } else {
            return "S???a th???t b???i";
        }
    }

    @Override
    public List<KhachHangDto> findKhachHang(String key) {
        _lstKhachHang = new ArrayList<>();
        List<KhachHang> listKh = khachHangRepository.findKhachHang(key);
        for (KhachHang x : listKh) {
            _lstKhachHang.add(new KhachHangDto(x.getId(), x.getMa(), x.getHoTen(), new java.sql.Date(x.getNgaySinh().getTime()),
                    x.getGioiTinh(), x.getSdt(), x.getDiaChi(), x.getEmail()));
        }
        return _lstKhachHang;
    }


    @Override
    public KhachHang findBySdt(String keyWord) {
        return khachHangRepository.findBySdt(keyWord);
    }

}
