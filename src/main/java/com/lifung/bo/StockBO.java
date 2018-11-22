package com.lifung.bo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StockBO {
	
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * insert sku 測試環境沒有的
	 * @param storerkey
	 * @return
	 */
	public int insertSKU(String storerkey) {
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(" insert into sku  " + 
				"select * from [LINK_TWN_WMS_PROD].twwms.dbo.sku sku1 (NOLOCK)  " + 
				"where sku1.storerkey=:storerkey and not exists (select * from sku (NOLOCK) where sku1.storerkey=sku.storerkey and sku1.sku=sku.sku)  " + 
				" ");
		query.setString("storerkey", storerkey);
	  int i=query.executeUpdate();
	  return i;
	}
	/**
	 * insert PACK 測試環境沒有的
	 * @param storerkey
	 * @return
	 */
	public int insertPACK(String storerkey) {
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(this.insertSQL());
			query.setString("storerkey", storerkey);
		  int i=query.executeUpdate();
		  return i;
	}
	
	public int insertLOC(String facility) {
		Query query2=this.sessionFactory.getCurrentSession().createSQLQuery(this.queryLocSQL());
		query2.setString("facility", facility);
		int size=Integer.valueOf( query2.list().get(0).toString());
		if(0==size) {
			return 0;
		}else {
			Query query=this.sessionFactory.getCurrentSession().createSQLQuery(this.insertLocSQL());
			query.setString("facility", facility);
		  int i=query.executeUpdate();
		  return i;
		}
		
	}
	/**
	 * insert temp
	 * @return
	 */
	public int insertTempStock(String storerkey,String sku) {
		boolean skuBoolean=false;
		if(!"".equals(sku.trim())&& null!=sku) {
			skuBoolean=true;
		}
		Query query1=this.sessionFactory.getCurrentSession().createSQLQuery("truncate table tempstock"); 
	    
	  System.out.println("trunctcate :"+query1.executeUpdate());
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(this.insertTempStockSQL(skuBoolean));
		query.setString("storerkey", storerkey);
		if(skuBoolean) {
		query.setString("sku", sku);
		}
	  int i=query.executeUpdate();
	  return i;
	}
	
	public int execNSP() {
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery("EXEC NSP_INSERTSTOCK '0'");
		 
	  int i=query.executeUpdate();
	  return i;
	}
	
	public boolean condition(ServletContext servletContext) throws Exception {
 
		Properties prop = new Properties();
		System.out.println(servletContext.getRealPath("/WEB-INF/jdbc.properties"));
		
		InputStream  input = null;
		input = new FileInputStream( servletContext.getRealPath("/WEB-INF/jdbc.properties"));
		prop.load(input);
		String condition=prop.getProperty("jdbc.databaseurl");
		System.out.println(condition);
		boolean c=false;
		if(null == condition || "".equals(condition)) {
			c=false;
		}else {
			c=condition.contains("VMSGWMSDBUT4");
		}
		return c; 
	}
	
	
	private String  insertSQL() {
		String cmd= 
				" insert   into pack(PackKey    " + 
				"                        ,PackDescr    " + 
				"                        ,PackUOM1    " + 
				"                        ,CaseCnt    " + 
				"                        ,ISWHQty1    " + 
				"                        ,ReplenishUOM1    " + 
				"                        ,ReplenishZone1    " + 
				"                        ,CartonizeUOM1    " + 
				"                        ,LengthUOM1    " + 
				"                        ,WidthUOM1    " + 
				"                        ,HeightUOM1     " + 
				"                        ,CubeUOM1    " + 
				"                        ,PackUOM2    " + 
				"                        ,InnerPack    " + 
				"                        ,ISWHQty2    " + 
				"                        ,ReplenishUOM2    " + 
				"                        ,ReplenishZone2    " + 
				"                        ,CartonizeUOM2    " + 
				"                        ,LengthUOM2    " + 
				"                        ,WidthUOM2    " + 
				"                        ,HeightUOM2    " + 
				"                        ,CubeUOM2    " + 
				"                        ,PackUOM3    " + 
				"                        ,Qty    " + 
				"                        ,ISWHQty3    " + 
				"                        ,ReplenishUOM3    " + 
				"                        ,ReplenishZone3    " + 
				"                        ,CartonizeUOM3    " + 
				"                        ,LengthUOM3    " + 
				"                        ,WidthUOM3    " + 
				"                        ,HeightUOM3    " + 
				"                        ,CubeUOM3    " + 
				"                        ,PackUOM4    " + 
				"                        ,Pallet    " + 
				"                        ,ISWHQty4    " + 
				"                        ,ReplenishUOM4    " + 
				"                        ,ReplenishZone4    " + 
				"                        ,CartonizeUOM4    " + 
				"                        ,LengthUOM4    " + 
				"                        ,WidthUOM4    " + 
				"                        ,HeightUOM4    " + 
				"                        ,CubeUOM4    " + 
				"                        ,PalletWoodLength    " + 
				"                        ,PalletWoodWidth    " + 
				"                        ,PalletWoodHeight    " + 
				"                        ,PalletTI    " + 
				"                        ,PalletHI    " + 
				"                        ,PackUOM5    " + 
				"                        ,Cube    " + 
				"                        ,ISWHQty5    " + 
				"                        ,PackUOM6    " + 
				"                        ,GrossWgt    " + 
				"                        ,ISWHQty6    " + 
				"                        ,PackUOM7    " + 
				"                        ,NetWgt    " + 
				"                        ,ISWHQty7    " + 
				"                        ,PackUOM8    " + 
				"                        ,OtherUnit1    " + 
				"                        ,ISWHQty8    " + 
				"                        ,ReplenishUOM8    " + 
				"                        ,ReplenishZone8    " + 
				"                        ,CartonizeUOM8    " + 
				"                        ,LengthUOM8    " + 
				"                        ,WidthUOM8    " + 
				"                        ,HeightUOM8    " + 
				"                        ,PackUOM9    " + 
				"                        ,OtherUnit2    " + 
				"                        ,ISWHQty9    " + 
				"                        ,ReplenishUOM9    " + 
				"                        ,ReplenishZone9    " + 
				"                        ,CartonizeUOM9    " + 
				"                        ,LengthUOM9    " + 
				"                        ,WidthUOM9    " + 
				"                        ,HeightUOM9)    " + 
				"                  SELECT PackKey    " + 
				"                        ,PackDescr    " + 
				"                        ,PackUOM1    " + 
				"                        ,CaseCnt    " + 
				"                        ,ISWHQty1    " + 
				"                        ,ReplenishUOM1    " + 
				"                        ,ReplenishZone1    " + 
				"                        ,CartonizeUOM1    " + 
				"                        ,LengthUOM1    " + 
				"                        ,WidthUOM1    " + 
				"                        ,HeightUOM1    " + 
				"                        ,CubeUOM1    " + 
				"                        ,PackUOM2    " + 
				"                        ,InnerPack    " + 
				"                        ,ISWHQty2    " + 
				"                        ,ReplenishUOM2    " + 
				"                        ,ReplenishZone2    " + 
				"                        ,CartonizeUOM2    " + 
				"                        ,LengthUOM2    " + 
				"                        ,WidthUOM2    " + 
				"                        ,HeightUOM2    " + 
				"                        ,CubeUOM2    " + 
				"                        ,PackUOM3    " + 
				"                        ,Qty    " + 
				"                        ,ISWHQty3    " + 
				"                        ,ReplenishUOM3    " + 
				"                        ,ReplenishZone3    " + 
				"                        ,CartonizeUOM3    " + 
				"                        ,LengthUOM3    " + 
				"                        ,WidthUOM3    " + 
				"                        ,HeightUOM3    " + 
				"                        ,CubeUOM3    " + 
				"                        ,PackUOM4    " + 
				"                        ,Pallet    " + 
				"                        ,ISWHQty4    " + 
				"                        ,ReplenishUOM4    " + 
				"                        ,ReplenishZone4    " + 
				"                        ,CartonizeUOM4    " + 
				"                        ,LengthUOM4    " + 
				"                        ,WidthUOM4    " + 
				"                        ,HeightUOM4    " + 
				"                        ,CubeUOM4    " + 
				"                        ,PalletWoodLength    " + 
				"                        ,PalletWoodWidth    " + 
				"                        ,PalletWoodHeight    " + 
				"                        ,PalletTI    " + 
				"                        ,PalletHI    " + 
				"                        ,PackUOM5    " + 
				"                        ,Cube    " + 
				"                        ,ISWHQty5    " + 
				"                        ,PackUOM6    " + 
				"                        ,GrossWgt    " + 
				"                        ,ISWHQty6    " + 
				"                        ,PackUOM7    " + 
				"                        ,NetWgt    " + 
				"                        ,ISWHQty7    " + 
				"                        ,PackUOM8    " + 
				"                        ,OtherUnit1    " + 
				"                        ,ISWHQty8    " + 
				"                        ,ReplenishUOM8    " + 
				"                        ,ReplenishZone8    " + 
				"                        ,CartonizeUOM8    " + 
				"                        ,LengthUOM8    " + 
				"                        ,WidthUOM8    " + 
				"                        ,HeightUOM8    " + 
				"                        ,PackUOM9    " + 
				"                        ,OtherUnit2    " + 
				"                        ,ISWHQty9    " + 
				"                        ,ReplenishUOM9    " + 
				"                        ,ReplenishZone9    " + 
				"                        ,CartonizeUOM9    " + 
				"                        ,LengthUOM9    " + 
				"                        ,WidthUOM9    " + 
				"                        ,HeightUOM9                       " + 
				"                    FROM LINK_TWN_WMS_PROD.TWWMS.dbo.PACK a (NOLOCK)  " + 
				"                    where EXISTS (select * FROM LINK_TWN_WMS_PROD.TWWMS.dbo.SKU b (NOLOCK) where b.storerkey=:storerkey and a.PACKKEY=b.PACKKEY)    " + 
				"                    and NOT EXISTS (select * from pack c (nolock) where a.PACKKEY=c.PACKKEY)  " + 
				"";
		return cmd;
	}
	private String insertTempStockSQL(boolean sku) {
		String skuCmd;
		if(sku) {
			  skuCmd="and  LOTXLOCXID.SKU=:sku";
		}else {
			  skuCmd="";
		}
		
		String cmd="Insert into " + 
				"tempstock (Storerkey,SKU,ID,LOC,QTY,LOTTABLE01,LOTTABLE02,LOTTABLE03,LOTTABLE04,LOTTABLE05,LOTTABLE06,LOTTABLE07,LOTTABLE08,LOTTABLE09,LOTTABLE10)" + 
				"SELECT " + 
				"LOTXLOCXID.STORERKEY," + 
				"LOTXLOCXID.SKU," + 
				"LOTXLOCXID.ID," + 
				"LOTXLOCXID.LOC," + 
				"LOTXLOCXID.QTY," + 
				"LOTATTRIBUTE.LOTTABLE01," + 
				"LOTATTRIBUTE.LOTTABLE02," + 
				"LOTATTRIBUTE.LOTTABLE03," + 
				"LOTATTRIBUTE.LOTTABLE04," + 
				"LOTATTRIBUTE.LOTTABLE05," + 
				"LOTATTRIBUTE.LOTTABLE06," + 
				"LOTATTRIBUTE.LOTTABLE07," + 
				"LOTATTRIBUTE.LOTTABLE08," + 
				"LOTATTRIBUTE.LOTTABLE09," + 
				"LOTATTRIBUTE.LOTTABLE10 FROM LINK_TWN_WMS_PROD.twwms.dbo.LOTXLOCXID as LOTXLOCXID (nolock) " + 
				"JOIN LINK_TWN_WMS_PROD.twwms.dbo.LOTATTRIBUTE as LotAttribute (nolock) ON LOTXLOCXID.STORERKEY=LOTATTRIBUTE.STORERKEY AND LOTXLOCXID.LOT=LOTATTRIBUTE.LOT " + 
				"WHERE LOTXLOCXID.STORERKEY=:storerkey AND LOTXLOCXID.QTY>0 "+skuCmd;
		return cmd;
	}
	
	private String insertLocSQL() {
		String cmd=" insert into loc(Loc,Cube,Length,Width,Height,LocationType,LocationFlag,LocationHandling,LocationCategory,LogicalLocation,CubicCapacity,WeightCapacity,Status,LoseId,Facility,ABC,PickZone,PutawayZone,SectionKey,PickMethod,CommingleSku,CommingleLot,LocLevel,Xcoord,Ycoord,Zcoord,TrafficCop,ArchiveCop,MaxPallet,LocAisle,HOSTWHCODE,CCLogicalLoc,ChargingPallet,EditWho,EditDate,AddWho,AddDate,LocCheckDigit,LastCycleCount,CycleCountFrequency,LoseUCC,NoMixLottable01,NoMixLottable02,NoMixLottable03,NoMixLottable04,LocBay,PALogicalLoc,Score,LocationRoom,LocationGroup,Floor,NoMixLottable05,NoMixLottable06,NoMixLottable07,NoMixLottable08,NoMixLottable09,NoMixLottable10,NoMixLottable11,NoMixLottable12,NoMixLottable13,NoMixLottable14,NoMixLottable15,CycleCounter) " + 
				"  select  Loc,Cube,Length,Width,Height,LocationType,LocationFlag,LocationHandling,LocationCategory,LogicalLocation,CubicCapacity,WeightCapacity,Status,LoseId,Facility,ABC,PickZone,PutawayZone,SectionKey,PickMethod,CommingleSku,CommingleLot,LocLevel,Xcoord,Ycoord,Zcoord,TrafficCop,ArchiveCop,MaxPallet,LocAisle,HOSTWHCODE,CCLogicalLoc,ChargingPallet,EditWho,EditDate,AddWho,AddDate,LocCheckDigit,LastCycleCount,CycleCountFrequency,LoseUCC,NoMixLottable01,NoMixLottable02,NoMixLottable03,NoMixLottable04,LocBay,PALogicalLoc,case when Score is null then 0 else score end score,LocationRoom,LocationGroup,Floor,NoMixLottable05,NoMixLottable06,NoMixLottable07,NoMixLottable08,NoMixLottable09,NoMixLottable10,NoMixLottable11,NoMixLottable12,NoMixLottable13,NoMixLottable14,NoMixLottable15,CycleCounter " + 
				" from LINK_TWN_WMS_PROD.TWWMS.dbo.LOC a " + 
				" where a.facility=:facility and  not exists(select  * from loc b where a.loc=b.loc)";
		
		return cmd;
	}
	
	private String queryLocSQL() {
		String cmd=" select  count(*) a " + 
				" from LINK_TWN_WMS_PROD.TWWMS.dbo.LOC a " + 
				" where a.facility=:facility  and  not exists(select  LOC from loc b where a.loc=b.loc)  " + 
				"";
		return cmd;
	}

}
