<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="mjack.net.PlayerMatImageServlet"%>
<%@page import="mjack.net.PlayerMat"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>

<html>
<head>
    <title>Test All</title>
</head>
<body>
<% 
  Properties nameProperties = new Properties();
  Properties artProperties = new Properties();
  ClassLoader loader = PlayerMat.class.getClassLoader();   
  
  InputStream stream = loader.getResourceAsStream("properties/mat_name.properties");
  nameProperties.load(stream);
  stream.close();

  stream = loader.getResourceAsStream("properties/art_info.properties");
  artProperties.load(stream);
  stream.close();

  //Check NameList for missing Art
  ArrayList<String> nameList = new ArrayList<String>(nameProperties.stringPropertyNames());
  boolean AllGood = true;
  for (String name : nameList) {
	  String artName = nameProperties.getProperty(name);
	  if (artName == null) {
		  %><p><%= name%> has no art</p>p> <% 
	  }
	  String artInfo = artProperties.getProperty(artName);
	  if (artInfo == null) {
		  %><p>Art <%= artInfo%> has no Info</p>p> <% 		  
	  }
  }
  
  //Print all Images
  int count = 0;
  for (String name : nameList) {
	  count++;
	  String artName = nameProperties.getProperty(name);
	  if (artName != null) {
		PlayerMat mat = new PlayerMat();
		mat.name = name;
		mat.topRowAction = new int[] {1,2,3,4};
		mat.initialResourceCost = new int[] {4,4,4,4};
		mat.finalResourceCost = new int[] {3,3,3,3};
		mat.coins = new int[] {0,1,2,3};
		mat.matNumber = 4;
		mat.bonusCoins = 5;
		mat.bonusPop = 3;   
		String imageStr = PlayerMatImageServlet.playerMatToSting(mat);
		String encodedStr = "PlayerMatImages/" + DatatypeConverter.printBase64Binary(imageStr.getBytes()) + ".png";
		%>
		<%= count %>:<br><img src="<%= encodedStr %>" alt="A Random PlayerMat" height="400" width="1024">
		<% 
		String artInfo = artProperties.getProperty(artName);
		if (artInfo != null) {
			String[] infoArr = artInfo.split("\\|");
			if (infoArr != null && infoArr.length == 4 && "unsplash.com".equals(infoArr[1]) ) {
				String artistName = infoArr[2];
				String artistLogin = infoArr[3];
				%> 
		<br>
		<p>Enjoying the background art?  See more from the artist at:
		<a style="background-color:black;color:white;text-decoration:none;padding:4px 6px;
		         font-family:-apple-system, BlinkMacSystemFont, &quot;San Francisco&quot;, &quot;Helvetica Neue&quot;, Helvetica, Ubuntu, Roboto, Noto, &quot;Segoe UI&quot;, Arial, sans-serif;font-size:12px;font-weight:bold;line-height:1.2;display:inline-block;border-radius:3px;" 
		         href="https://unsplash.com/@<%= artistLogin %>?utm_medium=referral&amp;utm_campaign=photographer-credit&amp;utm_content=creditBadge" 
		         target="_blank" rel="noopener noreferrer" title="Download free do whatever you want high-resolution photos from <%= artistName %>">
		         <span style="display:inline-block;padding:2px 3px;">
		             <svg xmlns="http://www.w3.org/2000/svg" style="height:12px;width:auto;position:relative;vertical-align:middle;top:-1px;fill:white;" viewBox="0 0 32 32">
				          <path d="M20.8 18.1c0 2.7-2.2 4.8-4.8 4.8s-4.8-2.1-4.8-4.8c0-2.7 2.2-4.8 4.8-4.8 2.7.1 4.8 2.2 4.8 4.8zm11.2-7.4v14.9c0 2.3-1.9 4.3-4.3 4.3h-23.4c-2.4 0-4.3-1.9-4.3-4.3v-15c0-2.3 1.9-4.3 4.3-4.3h3.7l.8-2.3c.4-1.1 1.7-2 2.9-2h8.6c1.2 0 2.5.9 2.9 2l.8 2.4h3.7c2.4 0 4.3 1.9 4.3 4.3zm-8.6 7.5c0-4.1-3.3-7.5-7.5-7.5-4.1 0-7.5 3.4-7.5 7.5s3.3 7.5 7.5 7.5c4.2-.1 7.5-3.4 7.5-7.5z"></path>
		             </svg></span><span style="display:inline-block;padding:2px 3px;">
		             <%= artistName %>
		         </span>
		</a>
		</p>
				<%
			}
			else if (infoArr != null && infoArr.length == 4 && "Web".equals(infoArr[1]) ) {
				String artistName = infoArr[2];
				String website = infoArr[3];
				%> 
		<br>
		<p>Enjoying the background art?  Original image can be found here: <a href="<%=website%>" target="_blank" rel="noopener noreferrer"><%= artistName %></a></p>
		        <%
			}
 		 }
      }
  }
%>







</body>
</html>