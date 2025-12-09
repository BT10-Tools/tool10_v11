#TOOL10 RELEASE NOTES
The Tool10 contains **File10** as the main module.
Based on **File10**, the modules **Image10**, **Doc10** and other modules will be developed.   

###Version 0.11 [2026-01]
* The specifications will be written.
* Will be developed as 2-5 day continuous commits. 
* Finally it will be frozen, planned for the first week of January 2026.   

###Version 0.10 [2025-12-09] 
* The first version of File10 is coded. 
* Only some critical fixes will be developed after the release.   
* **FileSet Database** designed in **Sqlite** with 15 tables. Around 5 of them not populated. 
* The **Loader**: It can traverse and load the files in a directory (not file, file list, directory list, drive etc.) 
* The **Extractor**: The extractor can extract the files but the file properties is not tested properly.  
* The **Compression**: Only **gzip** and **deflate** algorithms of standard Java is implemented. 
* The **Encryption**: Only **Byte Substitution Algorithm** is developed with 256 byte map. Even standard Java algorithms are not implemented. 
* The **Similarity**: Only Name Equality, Hash Equality and Content Equality of files and directories are implemented. The similarities are not implemented.  
* Only tested in **Windows Version 11**. **Linux**, **IOS** etc. are not tested.  
* **Logger** mechanism is started but not finished, gives some errors.
* no **GUI** is implemented. 
* The **Units Tests** are not developed, only some little start is done. 

Written by **Nursal Haney [bt10.com.tr]** on **9 December 2025**
  