package kr.co.constant;

public enum SnsUrlType {
	GOOGLE_CLIENT_ID("623303515879-49jko2pmshcjll86v28smkqc3pf3be9g.apps.googleusercontent.com"),
	GOOGLE_CLIENT_SECRET("LQ8DEeFpJPFWAqD67J8dexyZ"),
	GOOGLE_REDIRECT_URL("http://localhost:8089/users/auth/google/callback"),
	GOOGLE_ACCESS_TOKEN("https://www.googleapis.com/oauth2/v4/token?grant_type=authorization_code"),
	GOOGLE_AUTHORIZE("https://accounts.google.com/o/oauth2/auth"),
	GOOGLE_RESOURCE_URL("https://openidconnect.googleapis.com/v1/userinfo"),
	
	NAVER_CLIENT_ID("zXOm_uGtKBOA_ugnwdwz"),
	NAVER_CLIENT_SECRET("cdGoI1WGbl"),
	NAVER_REDIRECT_URL("http://localhost:8089/users/auth/naver/callback"),
	NAVER_ACCESS_TOKEN("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"),
	NAVER_AUTHORIZE("https://nid.naver.com/oauth2.0/authorize"),
	NAVER_RESOURCE_URL("https://openapi.naver.com/v1/nid/me"),
	
	KAKAO_CLIENT_ID("75bf355f857b2bcb55c29e0b30f71697"),
	KAKAO_CLIENT_SECRET("FTqlT3ABq8iQwbrZeHAkpg5FZzeUwwVc"),
	KAKAO_REDIRECT_URL("http://localhost:8089/users/auth/kakao/callback"),
	KAKAO_ACCESS_TOKEN("https://kauth.kakao.com/oauth/token?grant_type=authorization_code"),
	KAKAO_AUTHORIZE("https://kauth.kakao.com/oauth/authorize"),
	KAKAO_RESOURCE_URL("https://kapi.kakao.com/v2/user/me");
	
	private String url;
	
	SnsUrlType(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

}
