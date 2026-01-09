/**
 * Tool10 [ http://www.bt10.com.tr ]
 *
 * Tool10 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Open Tool10 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Tool10.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2025 bt10.com.tr Tool10. All Rights Reserved.
 *
 */

package tool10.f10;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * The main program for Tool10.  
 * It processes the arguments and calls other tool10 programs. 
 * Calls: fileSet, tagSet, imageSet, docSet, winRegistry
 * @author nhaney
 *
 */
public class Tool10 {
	
	private static final Logger logger =  LogManager.getLogger(Tool10.class);

	private static void printHeader(String lang)	{
		String strTr = 
			"-- Tool10: Dosya, Klasör, Görüntü, Doküman, Veri Analizi, Benzerlik ve Sistem Yönetimi için araç seti.\n" +
			"-- Bu program BT10 şirketi tarafından ve Balıkesir Üniversitesi öğrencilerinin katkıları ile geliştirilmiştir.\n"+
			"-- Proje Liderliği, Mimari ve Baş Programcılık: Nursal Haney, [BT10.com.tr] \n"+
			"-- Katkı Sağlayanlar: Betül Kızılkaya, Mualla Şahin, Ceyhun Emre Top, M.Utku Aksu, M.Utku İlbaş, Hiranur Akpınar, Hanife Kaptan, Buğra Yalçın, Eren Yetim, Ahmet Taner Gümüş.\n"+
			"-- Bu program ücretsizdir ve GNU General Public License Version 3 lisansı ile sağlanmaktadır, bu lisans çerçevesinde dağıtılabilir ve değiştirilebilir.\n"+
			"-- Programın faydalı olacağı umulmaktadır fakat her türlü sorumluluk kullanıcıya aittir.\n"+
			"-- Ticari, profesyonel, kurumsal sürümler ve lisanslama için bt10.com.tr ile irtibat kurunuz.\n"+
			"-- Mottomuz:Benzemez Kimse SANA.\n";		
		String strEng = 
			"-- Tool10: File, Directory, Image, Document, Data Analysis, Similarity and System Management Tool Set.\n" +
			"-- This program provided by BT10 and with contributions of Balikesir University students.\n"+
			"-- Project Lead, Architect and Senior Programmer: Nursal Haney, [BT10.com.tr] \n"+
			"-- Contributors: Betül Kızılkaya, Mualla Sahin, Ceyhun Emre Top, M.Utku Aksu, M.Utku Ilbas, Hiranur Akpınar, Hanife Kaptan, Bugra Yalcin, Eren Yetim, Ahmet Taner Gumus.\n"+
			"-- This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License Version 3 license.\n"+
			"-- This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.\n"+
			"-- Please contact bt10.com.tr for commercial, professional, enterprise versions and licensing.\n"+
			"-- Our Motto: No One Compares to YOU.\n";		
		if ("TR".equals(lang))	{
			System.out.println(strTr);
		} else if ("EN".equals(lang))	{
			System.out.println(strEng);	
		} 
	}
	public static NodeF10 getF10()	{
		BasicConfigurator.configure();
		NodeF10 f10 = new NodeF10();
		
		String[] args0 = CliRun.getArgs0("read");  //read must be selected
	    RunF10.runF10(f10,args0);
	    
		return(f10);
	}
	private static void runFileSet(String[] args)	{
		
		BasicConfigurator.configure();
		
		printHeader("TR");
		printHeader("EN");
		
		NodeF10 f10 = new NodeF10();
	    f10.startAll(logger);
		
	    String[] args0 = CliRun.getArgs0("loadblob");
	    RunF10.runF10(f10,args0);
	    
	    f10.endAll(logger);
	   
	}
	public static void main(String[] args) {
		runFileSet(args);
		//tagSet, imageSet, docSet, winRegistry,        		
	}
}
