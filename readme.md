# ssm练习项目 
# Kaptcha生成二维码 
## pom.xml  
	<!-- https://mvnrepository.com/artifact/com.github.penggle/kaptcha -->
	<dependency>
	 <groupId>com.github.penggle</groupId>
	 <artifactId>kaptcha</artifactId>
	 <version>2.3.2</version>
	</dependency>
## web.xml
	<servlet>
	 <servlet-name>Kaptcha</servlet-name>
	 <servlet-class>com.google.code.kaptcha.servlet.KaptchaServlet</servlet-class>
	<!-- no border -->
	<init-param>
	 <param-name>kaptcha.border</param-name>
	 <param-value>no</param-value>
	</init-param>
	<!-- font color is red -->
	<init-param>
	 <param-name>kaptcha.textproducer.font.color</param-name>
	 <param-value>red</param-value>
	</init-param>
	<!-- font size is 43 -->
	<init-param>
	 <param-name>kaptcha.textproducer.font.size</param-name>
	 <param-value>43</param-value>
	</init-param>
	<!-- noise color is black -->
	<init-param>
	 <param-name>kaptcha.noise.color</param-name>
	 <param-value>black</param-value>
	</init-param>
	<!-- image width is 135 -->
	<init-param>
	 <param-name>kaptcha.image.width</param-name>
	 <param-value>135</param-value>
	</init-param>
	<!-- image height is 50 -->
	<init-param>
	 <param-name>kaptcha.image.height</param-name>
	 <param-value>50</param-value>
	</init-param>
	<!-- char[] -->
	<init-param>
	 <param-name>kaptcha.textproducer.char.string</param-name>
	 <param-value>ACDEFGHIJKLMN235689</param-value>
	</init-param>
	<!-- char number -->
	<init-param>
	 <param-name>kaptcha.textproducer.char.length</param-name>
	 <param-value>4</param-value>
	</init-param>
	<!-- font -->
	<init-param>
	 <param-name>kaptcha.textproducer.font.names</param-name>
	 <param-value>Arial</param-value>
	</init-param>
	</servlet>
	<servlet-mapping>
	 <servlet-name>Kaptcha</servlet-name>
	 <url-pattern>/Kaptcha</url-pattern>
	</servlet-mapping>
## shopoperation.html
	<!-- 验证码 kaptcha -->
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">验证码</div>
									<input type="text" id="j_captcha" placeholder="验证码">
									<div class="item-input">
										<img id="captcha_img" alt="点击更换" title="点击更换"
											onclick="changeVerifyCode(this)" src="../Kaptcha">
									</div>
								</div>
							</div>
						</li>
## common.js
	function changeVerifyCode(img){
	img.src="../Kaptcha?" + Math.floor(Math.random()*100);
	alert('123');
}

## shopoperation.js
	var verfyCodeActual = $('#j_captcha').val();
					if(!verfyCodeActual){
						$.toast('请输入验证码!');
						return;
					}
					formData.append("verfyCodeActual",verfyCodeActual);
## CodeUtil.java
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verfyCodeActual = HttpServletRequestUtil.getString(request, "verfyCodeActual");
		if (verfyCodeActual == null || !verfyCodeActual.equals(verifyCodeExpected)) {
			return false;	
		}
		return true;
	}
		