package com.demo.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 
 * Constant.java Create on 2015-6-4 ионГ11:29:05
 * 
 * @author leizi
 * 
 */
public class Constant {

	public static final Version luceneVersion = Version.LUCENE_40;

	public static final Analyzer analyzer = new IKAnalyzer();

}
