package com.sample;

/* https://yonghwankim-dev.tistory.com/303
 * 자바빈즈 : 자바 클래스 중에 자바빈즈 규약에 맞게 작성된 클래스
 * 
 * 			멤버변수와 getter/setter
 * 			값을 저장하는 Value Object로 활용한다
 * 
 * 	액션태그
 * 	<jsp:useBean> 액션 태그
 * 		- 객체의 이름과 사용범위, 빈의 저장위치 등을 통해서 객체를 생성함
 *		  자바코드에서는 action의 id속성에 지정된 값을 통해서 객체를 참조함
 *				
 *		- 형식 : <jsp:useBean id="[빈이름]" class="[자바빈 클래스 이름]" scope="[범위]"/>
 * 			id : JSP 페이지에서 자바빈 객체에 접근할때 사용하는 이름(객체명)
 *			class : 패키지 이름을 포함한 자바빈 클래스의 완전한 이름
 *			scope : page, request, session, application 중 하나를 값으로 갖음, 자바빈 객체가 저장될 영역(기본:page)
 *
 *
 *
 *	<jsp:setProperty> : 자바빈 객체의 프로퍼티 값을 수정함
 *  <jsp:getProperty> : 자바빈 객체의 프로퍼티 값을 가져옴
 *		
 *
 *		- 형식 : <jsp:setProperty name="자바빈 이름" property="이름" value="[값]"/>
 *				 <jsp:getProperty name="자바빈 이름" property="프로퍼티 이름"/>
 *			--set--
 *			name : 프로퍼티의 값을 저장할 객체의 이름, <jsp:useBean> 액션 태그의 id 속성에서 지정한 값을 사용함
 *			property : 값을 저장할 프로퍼티 이름 param 속성의 값을 "*"으로 설정하면 
 *					   member 자바빈 객체의 프로퍼티들의 값을 각각 같은 이름을 갖는 파라미터의 값으로 설정합니다.
 *			value : 프로퍼티의 값, 표현식 사용 가능함
 *			--get--
 *			name : <jsp:useBean>의 id속성에서 지정한 자바빈 객체의 이름
 *			property : 출력할 프로퍼티의 이름
 *			
 *
 */

public class SimpleData{
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

