package kr.co.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;

@Getter
public enum SnsUrlGroup {
	GOOGLE(SnsUrlType.GOOGLE_CLIENT_ID, SnsUrlType.GOOGLE_CLIENT_SECRET, SnsUrlType.GOOGLE_REDIRECT_URL,
			SnsUrlType.GOOGLE_ACCESS_TOKEN, SnsUrlType.GOOGLE_AUTHORIZE, HttpMethod.POST, SnsUrlType.GOOGLE_RESOURCE_URL, "openid"),
	// GOOGLE 리소스서버 미정
	NAVER(SnsUrlType.NAVER_CLIENT_ID, SnsUrlType.NAVER_CLIENT_SECRET, SnsUrlType.NAVER_REDIRECT_URL,
			SnsUrlType.NAVER_ACCESS_TOKEN, SnsUrlType.NAVER_AUTHORIZE, HttpMethod.POST, SnsUrlType.NAVER_RESOURCE_URL, ""),
	KAKAO(SnsUrlType.KAKAO_CLIENT_ID, SnsUrlType.KAKAO_CLIENT_SECRET, SnsUrlType.KAKAO_REDIRECT_URL,
			SnsUrlType.KAKAO_ACCESS_TOKEN, SnsUrlType.KAKAO_AUTHORIZE, HttpMethod.POST, SnsUrlType.KAKAO_RESOURCE_URL, "");

	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private String accessTokenUrl;
	private String authorizeUrl;
	private HttpMethod METHOD;
	private String resourceUrl;
	private String scope;
	private SnsUrlGroup(SnsUrlType CLIENT_ID, SnsUrlType CLIENT_SECRET, SnsUrlType REDIRECT_URL,
			SnsUrlType ACCESS_TOKEN, SnsUrlType AUTHORIZE, HttpMethod METHOD, SnsUrlType RESOURCE_URL, String scope) {
		clientId = CLIENT_ID.getUrl();
		clientSecret = CLIENT_SECRET.getUrl();
		redirectUrl = REDIRECT_URL.getUrl();
		accessTokenUrl = ACCESS_TOKEN.getUrl();
		authorizeUrl = AUTHORIZE.getUrl();
		resourceUrl = RESOURCE_URL.getUrl();
		this.METHOD = METHOD;
		this.scope = scope;
	}

	public HttpMethod getMethod() {
		return METHOD;
	}
	
	public String getAuthorizationUrl() {
		String authorizationUrl = null;
			try {
				if(scope.isEmpty()) {
					authorizationUrl = new StringBuffer()
							.append(authorizeUrl)
							.append("?response_type=code")
							.append("&client_id=").append(clientId)
							.append("&redirect_uri=").append(URLEncoder.encode(redirectUrl, StandardCharsets.UTF_8.toString()))
							.toString();
				} else {
					authorizationUrl = new StringBuffer()
							.append(authorizeUrl)
							.append("?response_type=code")
							.append("&client_id=").append(clientId)
							.append("&redirect_uri=").append(URLEncoder.encode(redirectUrl, StandardCharsets.UTF_8.toString()))
							.append("&scope=").append(scope) //구글때문
							.toString();
				}
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("getAuthorizationUrl encode fail");
			}
		return authorizationUrl;
	}
	
	public String getSnsUniqueId (String code) throws IOException {
		RestTemplate rt = new RestTemplate();
		// HttpHeader 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		// HttpBody 
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("redirect_uri", redirectUrl);
		params.add("code", code);
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
		ResponseEntity<String> response = rt.exchange(accessTokenUrl, METHOD, tokenRequest, String.class);
		String body = response.getBody();
		
		
		ObjectMapper objectMapper1 = new ObjectMapper();
		JsonNode rootNode1 = objectMapper1.readTree(body);
		String access_token = rootNode1.get("access_token").asText();
		
		RestTemplate rt2 = new RestTemplate();
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + access_token);
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> profileRequest2 = new HttpEntity<>(headers2);
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange(resourceUrl, METHOD, profileRequest2,
				String.class);
		String body2 = response2.getBody();
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		JsonNode rootNode2 = objectMapper2.readTree(body2);
		String id = null;
		if (rootNode2.has("response"))
			id = rootNode2.get("response").get("id").asText();
		else if(rootNode2.has("sub"))
			id= rootNode2.get("sub").asText();
		else
			id = rootNode2.get("id").asText();
		return id;
	}

}
