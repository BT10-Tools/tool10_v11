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

package tool10;

import java.time.ZonedDateTime;

import tool10.fileset.CliFileSetRun;
import tool10.fileset.MainFileSet;
import tool10.fileset.NodeF10;
import tool10.util.TimeUtil;

/**
 * The main program for Tool10.  
 * It processes the arguments and calls other tool10 programs. 
 * Calls: fileSet, tagSet, imageSet, docSet, winRegistry
 * @author nhaney
 *
 */
public class Tool10 {
	
	private static void printHeader(String lang)	{
		String strTr = 
			"-- Tool10: Dosya, Klasör, Görüntü, Doküman, Veri Analizi ve Sistem Yönetimi için araç seti.\n" +
			"-- Bu program BT10 şirketi tarafından ve Balıkesir Üniversitesi öğrencilerinin katkıları ile geliştirilmiştir.\n"+
			"-- Proje Liderliği, Mimari ve Baş Programcılık: Nursal Haney, [BT10.com.tr] \n"+
			"-- Katkı Sağlayanlar: Betül Kızılkaya, Mualla Şahin, Ceyhun Emre Top, M.Utku Aksu, M.Utku İlbaş, Hiranur Akpınar, Hanife Kaptan, Buğra Yalçın, Eren Yetim, Ahmet Taner Gümüş.\n"+
			"-- Bu program ücretsizdir ve GNU General Public License Version 3 lisansı ile sağlanmaktadır, bu lisans çerçevesinde dağıtılabilir ve değiştirilebilir.\n"+
			"-- Programın faydalı olacağı umulmaktadır fakat her türlü sorumluluk kullanıcıya aittir.\n"+
			"-- Ticari, profesyonel, kurumsal sürümler ve lisanslama için bt10.com.tr ile irtibat kurunuz.\n";		
		String strEng = 
			"-- Tool10: File, directory, Image, Document, Data Analysis and System Management Tool Set.\n" +
			"-- This program provided by BT10 and with contributions of Balikesir University students.\n"+
			"-- Project Lead, Architect and Senior Programmer: Nursal Haney, [BT10.com.tr] \n"+
			"-- Contributors: Betül Kızılkaya, Mualla Sahin, Ceyhun Emre Top, M.Utku Aksu, M.Utku Ilbas, Hiranur Akpınar, Hanife Kaptan, Bugra Yalcin, Eren Yetim, Ahmet Taner Gumus.\n"+
			"-- This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License Version 3 license.\n"+
			"-- This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.\n"+
			"-- Please contact bt10.com.tr for commercial, professional, enterprise versions and licensing.\n";		
		if ("TR".equals(lang))	{
			System.out.println(strTr);
		} else if ("EN".equals(lang))	{
			System.out.println(strEng);	
		} 
	}
	private static void runFileSet(String[] args)	{
		printHeader("TR");
		printHeader("EN");
		ZonedDateTime startZdt = ZonedDateTime.now();
		System.out.println("Tool10 runFileSet Execution Start Time:"+ZonedDateTime.now());
		NodeF10 f10 = new NodeF10();
	    
	    String[] args0 = CliFileSetRun.getArgs0();
	    MainFileSet.runF10(f10,args0);
	    ZonedDateTime finishZdt = ZonedDateTime.now();
	    long runTimeInMillis = TimeUtil.diffInMillisZDT(startZdt, finishZdt);
	    
	    System.out.println("Tool10 runFileSet Execution Finish Time:"+ZonedDateTime.now() + ", run time in milliseconds:"+runTimeInMillis);
	}
	public static void main(String[] args) {
		runFileSet(args);
		//tagSet, imageSet, docSet, winRegistry,        		
	}
}
