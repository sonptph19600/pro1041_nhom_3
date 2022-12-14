package pro1041.team_3.repository;

import java.util.List;
import pro1041.team_3.domainModel.MauSac;
import pro1041.team_3.dto.MauSacDto;
import java.util.UUID;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pro1041.team_3.dto.ChiTietDienThoaiDto;
import pro1041.team_3.util.HibernateUtil;

/**
 *
 * @author vanntph19604
 */
public class MauSacRepository extends Repository<MauSac, UUID, MauSacDto> {

    public MauSacRepository() {
        className = MauSac.class.getName();
        resCon = "new pro1041.team_3.dto.MauSacDto(a.id, a.ma, a.ten)";
        join = " order by CONVERT(INT, SUBSTRING(a.ma, 2, 10)) desc";
    }
    
    public List<MauSacDto> findByName(String keyWord){
        try {
            List<MauSacDto> lst;
            session = HibernateUtil.getSession();
            String hql = "SELECT " + resCon + " FROM " + className + " a WHERE a.ten LIKE CONCAT('%', :keyWord, '%') " + join;
            Query query = session.createQuery(hql);
            query.setParameter("keyWord", keyWord);
            lst = query.getResultList();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public MauSac findMauSacByName(String ten) {
        MauSac entity = null;
        try {
            
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.ten = :ten";
            TypedQuery<MauSac> query = session.createQuery(hql, MauSac.class);
            query.setParameter("ten", ten);
            List<MauSac> lst = query.getResultList();
            if (!lst.isEmpty()) {
                entity = lst.get(0);
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ChiTietDienThoaiDto checkMSTrongCtdt(UUID id) {
        ChiTietDienThoaiDto chiTietDienThoaiDto = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "select new pro1041.team_3.dto.ChiTietDienThoaiDto(a.id, a.hang.id, a.mauSac.id, a.dienThoai.id) from ChiTietDienThoai a "
                    + " where a.mauSac.id = :id ";
            TypedQuery<ChiTietDienThoaiDto> query = session.createQuery(hql, ChiTietDienThoaiDto.class);
            query.setParameter("id", id);
            List<ChiTietDienThoaiDto> lst = query.getResultList();
            if (!lst.isEmpty()) {
                chiTietDienThoaiDto = lst.get(0);
            }
            return chiTietDienThoaiDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
