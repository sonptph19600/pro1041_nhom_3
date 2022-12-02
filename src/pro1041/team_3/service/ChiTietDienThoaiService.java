package pro1041.team_3.service;


import java.util.List;
import java.util.UUID;
import pro1041.team_3.domainModel.ChiTietDienThoai;
import pro1041.team_3.dto.ChiTietDienThoaiResponse;

/**
 *
 * @author trangdttph27721
 */
public interface ChiTietDienThoaiService {

    List<ChiTietDienThoaiResponse> getAllResponse();
    
    List<ChiTietDienThoaiResponse> getAllTrangThai(int trangThai);

    void insert(ChiTietDienThoai chiTietSP);

    void update(ChiTietDienThoai chiTietSP);

    String delete(String ma);

    ChiTietDienThoai getID(String ma);

    List<ChiTietDienThoaiResponse> findBy(String keyWord);

    List<ChiTietDienThoaiResponse> sapXep(String chieu);

    List<ChiTietDienThoaiResponse> sapXep2(String loai, String chieu);
    
    List<ChiTietDienThoaiResponse> getAllDienThoaiNotInKM(UUID id);
    
    List<ChiTietDienThoaiResponse> getAllCTDTNotInKMByDienThoai(UUID id, String tenDienThoai);
    
    List<ChiTietDienThoaiResponse> getAllCTDTNotInKMByHang(UUID id, String tenHang);
    
    List<ChiTietDienThoaiResponse> getAllCTDTNotInKMByMauSac(UUID id, String tenMauSac);
    
    List<ChiTietDienThoaiResponse> getAllCTDTNotInKMByTinhTrang(UUID id, int tinhTrang);
    
    List<ChiTietDienThoaiResponse> getAllCTDienThoaiByDienThoai(String tenDienThoai);
    
    List<ChiTietDienThoaiResponse> getAllCTDienThoaiByHang(String tenHang);
    
    List<ChiTietDienThoaiResponse> getAllCTDienThoaiByMauSac(String tenMauSac);
    
    List<ChiTietDienThoaiResponse> getAllCTDienThoaiByTinhTrang(int tinhTrang);

}
