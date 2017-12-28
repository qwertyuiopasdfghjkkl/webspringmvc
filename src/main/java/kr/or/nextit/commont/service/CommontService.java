package kr.or.nextit.commont.service;

import java.util.List;
import java.util.Map;

import kr.or.nextit.commont.model.Commont;

public interface CommontService {

	public int getCommontCount(Map<String, Object> paramMap) throws Exception;

	public List<Commont> getCommontList(Map<String, Object> paramMap) throws Exception;

	public Commont getCommont(int comment_num) throws Exception;

	public int insertCommont(Commont commont) throws Exception;

	public int updatCommont(Commont commont) throws Exception;

	public int deletCommont(Map<String, Object> paramMap) throws Exception;
	
}
