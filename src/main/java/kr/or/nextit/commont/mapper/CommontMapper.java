package kr.or.nextit.commont.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.commont.model.Commont;

@Mapper
public interface CommontMapper {
	
	public int selectCommontCount(Map<String, Object> paramMap) throws Exception;
	
	public List<Commont> selectCommontList(Map<String, Object>paramMap) throws Exception;
	
	public Commont selectCommont(int comment_num) throws Exception;
	
	public int insertCommont(Commont commont) throws Exception;
	
	public int updateCommont(Commont commont) throws Exception;
	
	public int deleteCommont(Map<String, Object> paramMap);
	
	public int updateHitCnt(int comment_num) throws Exception;
}
