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
 * CreateIndex.java Create on 2015-6-4 ����10:53:46
 * 
 * @author  leizi
 * 
 */
public class CreateIndex {

	public void createIndex(){
		String fileName = "text";
		String texts[] = {"�ܲ�", "�ܲ�����", "��������ʦ", "��ʦ", ".net��������ʦ", "js��������ʦ", "������Ա", "ʦ��", "�÷�"};
		
		IndexWriter writer = null;
		Directory directory = null;
		try {
			//1������directory
			//Directory directory = new RAMDirectory(); //�����ڴ�directory
			directory = FSDirectory.open(new File("E:/lucene4Demo/index/" + System.currentTimeMillis()));
			
			//LimitTokenCountAnalyzer��4.0�д���3.0��IndexWriter.MaxFieldLength���������С��������õ����СΪ100��
			LimitTokenCountAnalyzer maxFieldLength = new LimitTokenCountAnalyzer(Constant.analyzer, 100);
			
			//2������IndexWriter
			IndexWriterConfig iwConfig = new IndexWriterConfig(Constant.luceneVersion, maxFieldLength);
			LogDocMergePolicy mergePolicy = new LogDocMergePolicy();
			mergePolicy.setMergeFactor(500); //�ϲ����ӣ�������һ���������а������ٸ��ĵ�����Ӳ���ϵ�������ﵽ����ʱ�������Ǻϲ���һ���ϴ��������
			iwConfig.setMaxBufferedDocs(500); //������󻺴��ĵ���
			iwConfig.setMergePolicy(mergePolicy);
			
	        writer = new IndexWriter(directory, iwConfig);
	        
	        //3������document����
	        Document document = null;
	        for(String text : texts){
	        	document = new Document();
	        	document.add(new TextField(fileName, text, Field.Store.YES));	
	        	writer.addDocument(document);
	        }
		} catch (Exception e) {
		}finally{
			try {
				//�ϲ���������Ӧ����3.0��IndexWriter.optimize()
				//�Ὣ�����ϲ�Ϊ2�Σ��������еı�ɾ�������ݻᱻ���
		        //�ر�ע�⣺�˴�Lucene��3.5֮�󲻽���ʹ�ã���Ϊ�����Ĵ����Ŀ�����
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
