package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.vo.Product;
/**
 * ��Ʒ�־ò�ӿ�
 * @author OMGؼ����
 *
 */
public interface ProductDao extends BaseDao<Product>{
    /**
     * ��ҳ������Ʒ��ѯ
     * @return
     */
	List<Product> findHotProduct();
    /**
     * ��ҳ������Ʒ��ʾ
     * @return
     */
	List<Product> findNewProduct();
    /**
     * ����һ��Ŀ¼��ѯ��Ʒ����
     * @param cid
     * @return
     */
	int findCountCid(Integer cid);
    /**
     * ���ݷ���cid��ѯ��Ʒ����
     * @param cid
     * @param begin
     * @param limit
     * @return
     */
	List<Product> findByPageCid(Integer cid,int begin,int limit);
    /**
     * ���ݶ���Ŀ¼csid��ѯ��Ʒ����
     * @param csid
     * @return
     */
	int findCountCsid(Integer csid);
	/**
	 * ���ݶ���ľĿ¼csid��ѯ��Ʒ����
	 * @param csid
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Product> findByPageCsid(Integer csid, int page, int limit);
	int findCount();
	List<Product> findByPage(int begin, int limit);

}
