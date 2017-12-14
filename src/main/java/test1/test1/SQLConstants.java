package test1.test1;

public final class SQLConstants {
  
	 public static final String GET_ALL_VENDOR_IDS_QUERY =
	          "select distinct vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
	  
	 
	 
	 public static final String GET_CITY_LANDMARKS_QUERY =
	          "select Poi_Name as landmarkName, poi_Seo_Id as landmarkSEOName,cp.latitude,cp.longitude,c.City_Name as city from DS_CITY_POI cp,DS_CITY c where c.City_id = cp.City_Id";
	  public static final String GET_VENDOR_DETAILS_QUERY =
	          "select DISTINCT a.Vendor_Id, a.is_featured, a.No_Of_BathRooms ,a.HotelSearchKey, a.Property_Managed_By, a.Things_To_Add, a.IS_ANYTIME_CHECKIN,  a.Book_Instantly, a.Property_Build_Date"
	                  + ",a.Vendor_Name,a.City,a.Country, a.No_Of_Floors,a.HotelSearchKey, a.No_Of_Rooms,a.seo_Name,  a.latitude, a.longitude, CONVERT(VARCHAR,a.DS_CHECKIN_TIME,108)"
	                  + " as DS_CHECKIN_TIME, CONVERT(VARCHAR,a.DS_CHECKOUT_TIME,108) as  DS_CHECKOUT_TIME, a.TripAdvisor_ID,a.Hotel_Star, a.Fax_no_Country_Code,a.Fax_no_Area_Code"
	                  + ",a.Fax_No, a.Supplier_Source,a.Address_1, a.Address_2, a.Pin_Code,a.Area, a.City, a.City_Zone, a.state,a. Area, a.Area_Id ,a.PROPERTY_TYPE,a.Yatra_Triple_Gurantee"
	                  + ",a.Original_Vendor_Name,a.Stop_Sell, a.Cards_Allowed, a.is_govt_verified, cs.Seo_City_Name, r.Area_Seo_Id, c.Phone_no_Counrty_Code, c.Phone_no_Area_Code,c.Phone_no "
	                  + "from DS_REGISTERED_VENDOR a left join DS_CITY cs on a.City=cs.City_Name left join DS_CITIES_AREA r on ltrim(rtrim(lower(a.Area)))=ltrim(rtrim(lower(r.Area)))"
	                  + " left join DS_VENDOR_CONTACT c on c.Vendor_Id=a.Vendor_Id where a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.vendor_id in (<KEYSET>)";
	  public static final String GET_CONTENT_DESC_QUERY =
	          "select Content_type,Vendor_id, Content_desc1, Content_desc2, Yatra_Content_desc3 from DS_CONTENT where Content_type in ('HO','HA') and vendor_id in (<KEYSET>)";
	  public static final String GET_CONTENT_THEME_QUERY =
	          "select a.Seo_id,a.Theme_Id,a.Theme_Name,b.Vendor_Id from DS_THEME a, ds_vendor_theme_mapping b where a.Theme_Id = b.Theme_Id and b.Vendor_Id in (<KEYSET>)";
	  public static final String GET_HS_RANK_QUERY =
	          "select distinct DSRV.vendor_id vendor_id,SUBSTRING((SELECT ',' + RTRIM(LTRIM(dct.Seo_City_Name)) FROM DS_HOTEL_DYNAMIC_RANK DSHSO JOIN DS_REGISTERED_VENDOR af "
	                  + "ON DSHSO.Vendor_Id = af.Vendor_Id JOIN DS_CITY dct ON dct.City_Name = DSHSO.City_Name where DSRV.Vendor_Id =DSHSO.Vendor_Id and DSHSO.CITY_NAME in "
	                  + "(Select city from DS_AREA_OF_INFLUENCE where Area_Of_Influence =af.city) FOR XML PATH('')), 2, 1000000)seo_area_of_influence, SUBSTRING((SELECT ',' + RTRIM(LTRIM(DSHSO.City_Name))"
	                  + " FROM DS_HOTEL_DYNAMIC_RANK DSHSO JOIN DS_REGISTERED_VENDOR af ON DSHSO.Vendor_Id = af.Vendor_Id where DSRV.Vendor_Id =DSHSO.Vendor_Id  and DSHSO.CITY_NAME  in (Select city from "
	                  + "DS_AREA_OF_INFLUENCE where Area_Of_Influence =af.city) FOR XML PATH('')), 2, 1000000)area_of_influence,SUBSTRING((SELECT ',' + RTRIM(LTRIM(DSHSO.City_Name))+"
	                  + "':'+RTRIM(LTRIM(DSHSO.MANUAL_WEEKDAY_RANK)) FROM DS_HOTEL_DYNAMIC_RANK DSHSO JOIN DS_REGISTERED_VENDOR af ON DSHSO.Vendor_Id = af.Vendor_Id where DSRV.Vendor_Id = DSHSO.Vendor_Id "
	                  + "and DSHSO.CITY_NAME  in (Select city from DS_AREA_OF_INFLUENCE where Area_Of_Influence =af.city) FOR XML PATH('')), 2, 1000000) manual_weekday_rank, "
	                  + "SUBSTRING((SELECT ',' + RTRIM(LTRIM(DSHSO.City_Name))+':'+RTRIM(LTRIM(DSHSO.MANUAL_WEEKEND_RANK)) FROM DS_HOTEL_DYNAMIC_RANK DSHSO JOIN DS_REGISTERED_VENDOR af ON DSHSO.Vendor_Id = "
	                  + "af.Vendor_Id where DSRV.Vendor_Id = DSHSO.Vendor_Id and DSHSO.CITY_NAME  in (Select city from DS_AREA_OF_INFLUENCE where Area_Of_Influence =af.city) FOR XML PATH('')), 2, 1000000) "
	                  + "manual_weekend_rank FROM DS_HOTEL_DYNAMIC_RANK DSRV where DSRV.vendor_id in (<KEYSET>)";
	  public static final String GET_VENDOR_CATEGORY_QUERY =
	          "select cm.Vendor_Id, cm.Category_Id,c.Category_Name,c.Seo_Id from DS_HOTEL_CATEGORY_MAPPING cm inner join  DS_CATEGORY c on  c.Category_Id = cm.Category_Id where Vendor_Id in (<KEYSET>) order by cm.Vendor_Id";
	  public static final String GET_HS_AMENITY_QUERY =
	          "select a.Vendor_id, RTRIM(LTRIM(a.Amenity_id)) as Amenity_id, b.Amenity_type,b.Seo_Id, RTRIM(LTRIM(b.Amenity_Description)) as Amenity_Description, b.Offered_YN, b.category, a.price,a.modifiedCategory from DS_VENDOR_AMENITY a, DS_AMENITIES b where a.Amenity_id = b.Amenity_id and (b.Amenity_type='property' or b.Amenity_type='room') and a.vendor_id in (<KEYSET>) order by a.Vendor_id, b.Amenity_type";
	  public static final String GET_ALL_HS_ROOM_AMENITY_QUERY =
	          "select a.Vendor_id, RTRIM(LTRIM(a.Amenity_id)) as Amenity_id, b.Amenity_type, RTRIM(LTRIM(b.Amenity_Description)) as Amenity_Description, b.Offered_YN, b.category from DS_VENDOR_AMENITY a, DS_AMENITIES b where a.Amenity_id = b.Amenity_id and b.Amenity_type='room' and a.vendor_id in (<KEYSET>) order by a.Vendor_id, b.Amenity_type";
	  public static final String GET_HS_COMMON_POLICY_QUERY =
	          "select Policy_Id,Policy_Text,Policy_Type from DS_HOTEL_POLICIES where Active = 1 and Policy_Type='COMMON'";
	  public static final String GET_VENDOR_HS_POLICY_QUERY =
	          "select vp.Vendor_Id as Vendor_Id, hp.Policy_Id as Policy_Id,hp.Policy_Text as Policy_Text, hp.Policy_Type as Policy_Type from DS_HOTEL_POLICIES as hp, DS_VENDOR_POLICY_MAPPINGS as vp where hp.Policy_Id = vp.Policy_Id and hp.Active = 1 and vp.Vendor_Id in (<KEYSET>) order by vp.Vendor_Id";
	  public static final String GET_ROOMTYPE_AMENITY_QUERY =
	          "select a.Vendor_id, a.RoomType_id, a.RoomType_Name, a.price, b.Amenity_id,b.Amenity_Description,b.category from DS_RoomType_Ameneties a, DS_AMENITIES b where a.Amenity_id=b.Amenity_id and b.Amenity_type='roomamenities' and a.Vendor_id in (<KEYSET>) order by a.Vendor_id, a.RoomType_id";
	  public static final String GET_ROOMTYPE_DETAILS_QUERY =
	          "select a.Vendor_id, a.RoomType_id, a.Room_Type, a.Room_Size, a.Bed_Size, a.propertyLevel, a.Max_Guest_Occupancy, b.BedCount, c.Bedding_Type from DS_ROOM_TYPE a LEFT OUTER JOIN DS_ROOM_BEDDING b on a.RoomType_id=b.RoomType_id LEFT OUTER JOIN  DS_BEDDING c on b.Bedding_Id=c.Bedding_Id where a.Vendor_id in (<KEYSET>) ORDER by a.Vendor_id, a.RoomType_id";

}