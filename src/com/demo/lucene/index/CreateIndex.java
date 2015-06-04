package com.demo.lucene.index;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.miscellaneous.LimitTokenCountAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.demo.lucene.Constant;


/** 
 *
 * CreateIndex.java Create on 2015-6-4 上午10:53:46
 * 
 * @author  leizi
 * 
 */
public class CreateIndex {

	public void createIndex(){
		String fileName = "text";
		String texts[] = {"总裁", "总裁助理", "开发工程师", "老师", ".net开发工程师", "js开发工程师", "销售人员", "师父", "裁缝"};
		
		IndexWriter writer = null;
		Directory directory = null;
		try {
			//1、创建directory
			//Directory directory = new RAMDirectory(); //创建内存directory
			directory = FSDirectory.open(new File("E:/lucene4Demo/index/" + System.currentTimeMillis()));
			
			//LimitTokenCountAnalyzer在4.0中代替3.0中IndexWriter.MaxFieldLength类设置域大小，这个设置的域大小为100项
			LimitTokenCountAnalyzer maxFieldLength = new LimitTokenCountAnalyzer(Constant.analyzer, 100);
			
			//2、创建IndexWriter
			IndexWriterConfig iwConfig = new IndexWriterConfig(Constant.luceneVersion, maxFieldLength);
			LogDocMergePolicy mergePolicy = new LogDocMergePolicy();
			mergePolicy.setMergeFactor(500); //合并因子，决定了一个索引块中包括多少个文档，当硬盘上的索引块达到多少时，将它们合并成一个较大的索引块
			iwConfig.setMaxBufferedDocs(500); //设置最大缓存文档数
			iwConfig.setMergePolicy(mergePolicy);
			
	        writer = new IndexWriter(directory, iwConfig);
	        
	        //3、创建document对象
	        Document document = null;
	        for(String text : texts){
	        	document = new Document();
	        	document.add(new TextField(fileName, text, Field.Store.YES));	
	        	writer.addDocument(document);
	        }
		} catch (Exception e) {
		}finally{
			try {
				//合并索引，对应的是3.0的IndexWriter.optimize()
				//会将索引合并为2段，这两段中的被删除的数据会被清空
		        //特别注意：此处Lucene在3.5之后不建议使用，因为会消耗大量的开销，
				//writer.forceMerge(1);
				
				if (writer != null){
					writer.close();
				}
				if (directory != null){
					directory.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		new CreateIndex().createIndex();
	}
}
