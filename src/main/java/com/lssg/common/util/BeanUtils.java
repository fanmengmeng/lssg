package com.lssg.common.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.tools.Tool;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.lang.reflect.Array;
import java.util.Date;
 
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
@SuppressWarnings("unchecked")
public class BeanUtils {
	public static <T> T xmlToBean(String xml, Class<T> clazz) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	public static String beanToXML(Object bean) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(bean.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			StringWriter writer = new StringWriter();
			marshaller.marshal(bean, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  使用泛型方法，把json字符串转换为相应的JavaBean对象。
	 * @param content
	 * @param valueType
	 * @return 
	 * @return
	 */
	public static <T> T readValue(String content, Class<T> valueType) {
		T t = null;
		JSONObject json = JSONObject.fromObject(content);
		System.out.println(json);
		
		//ObjectMapper objectMapper = new ObjectMapper();
	  
		try {
			t = (T) JSONObject.toBean(JSONObject.fromObject(json.getString("data")), valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
}
