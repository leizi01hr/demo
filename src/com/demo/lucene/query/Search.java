package com.demo.lucene.query;

import java.io.File;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.demo.lucene.Constant;

/**
 * 
 * Search.java Create on 2015-6-4 上午11:20:22
 * 
 * @author leizi
 * 
 */
public class Search {

	public static void main(String[] args) {
		new Search().test();
	}

	public void test() {
		DirectoryReader reader = null;
		TopDocs topDocs = null;
		try {
			// 1、创建Directory
			Directory directory = FSDirectory.open(new File("E:/lucene4Demo/index/1433397169875"));
			
			// 2、创建IndexReader
			reader = DirectoryReader.open(directory);
			
			// 3、根据IndexWriter创建IndexSearcher
			IndexSearcher searcher = new IndexSearcher(reader);

			BooleanQuery bq = new BooleanQuery();

			QueryParser qp = new QueryParser(Version.LUCENE_40, "text", Constant.analyzer);
			Query query = qp.parse("工程师 ");
			bq.add(query, BooleanClause.Occur.MUST);

			System.out.println(bq);
			
			Sort sort = new Sort(SortField.FIELD_SCORE);
			if (bq.getClauses().length > 0) {
				topDocs = searcher.search(bq, null, 10, sort);
			} else {
				topDocs = searcher.search(new org.apache.lucene.search.MatchAllDocsQuery(), null, 10, sort);
			}
			// 总命中数
			System.out.println(topDocs.totalHits);

			ScoreDoc[] hits = topDocs.scoreDocs;
			int size = hits.length;
			for (int i = 0; i < size; i++) {
				int docId = hits[i].doc;
				Document document = searcher.doc(docId);
				System.out.println(document.toString());
			}
		} catch (Exception e) {
		}
	}
}
