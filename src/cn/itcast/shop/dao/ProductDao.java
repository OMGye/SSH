package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.vo.Product;
/**
 * 商品持久层接口
 * @author OMG丶爱月
 *
 */
public interface ProductDao extends BaseDao<Product>{
    /**
     * 首页热门商品查询
     * @return
     */
	List<Product> findHotProduct();
    /**
     * 首页最新商品显示
     * @return
     */
	List<Product> findNewProduct();
    /**
     * 根据一级目录查询商品数量
     * @param cid
     * @return
     */
	int findCountCid(Integer cid);
    /**
     * 根据分类cid查询商品集合
     * @param cid
     * @param begin
     * @param limit
     * @return
     */
	List<Product> findByPageCid(Integer cid,int begin,int limit);
    /**
     * 根据二级目录csid查询商品数量
     * @param csid
     * @return
     */
	int findCountCsid(Integer csid);
	/**
	 * 根据二级木目录csid查询商品集合
	 * @param csid
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Product> findByPageCsid(Integer csid, int page, int limit);
	int findCount();
	List<Product> findByPage(int begin, int limit);

}
