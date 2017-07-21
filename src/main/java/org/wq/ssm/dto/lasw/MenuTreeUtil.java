package org.wq.ssm.dto.lasw;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.wq.ssm.entity.lasw.LaswMenu;

public class MenuTreeUtil {
	public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();  
    public List<LaswMenu> menuCommon;  
    public List<Object> list = new ArrayList<Object>(); 
    
    public List<Object> menuList(List<LaswMenu> menu){      
        this.menuCommon = menu;  
        for (LaswMenu x : menu) {     
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();  
            if(x.getParentId()==null || x.getParentId()==0){  
                mapArr.put("id", x.getId());  
                mapArr.put("nameC", x.getNameChina());  
                mapArr.put("nameE", x.getNameEnglish());  
                mapArr.put("desC", x.getDesChina());  
                mapArr.put("desE", x.getDesEnglish());  
                mapArr.put("child", menuChild(x.getId()));    
                list.add(mapArr);  
            }  
        }     
        return list;  
    }  
      
      
    public List<?> menuChild(Long id){  
        List<Object> lists = new ArrayList<Object>();  
        for(LaswMenu a:menuCommon){  
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();  
            if(a.getParentId() !=null && a.getParentId() == id){  
                childArray.put("id", a.getId());  
                childArray.put("nameC", a.getNameChina());  
                childArray.put("nameE", a.getNameEnglish());  
                childArray.put("desC", a.getDesChina());  
                childArray.put("desE", a.getDesEnglish());  
                childArray.put("child", menuChild(a.getId()));    
                lists.add(childArray);  
            }  
        }  
        return lists;  
          
    }  
    
    
}
