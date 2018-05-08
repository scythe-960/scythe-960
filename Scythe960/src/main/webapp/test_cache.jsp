<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="mjack.net.PlayerMatImageServlet"%>
<%@page import="mjack.net.PlayerMat"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>

<html>
<head>
    <title>Test Cache</title>
</head>
<body>
<% 

  int[][] LegalTRAs = PlayerMat.LegalTRAs; 
  int[][] LegalCoins = PlayerMat.LegalCoins; 
  int[][][] LegalBRACosts = PlayerMat.LegalBRACosts;
  int numMats = LegalBRACosts.length;

  for (int i = 0; i < numMats; i++) {
	  PlayerMat mat = new PlayerMat();
	  mat.name = "Balanced";
	  mat.topRowAction = LegalTRAs[i % LegalTRAs.length];
	  mat.initialResourceCost = LegalBRACosts[i][0];
	  mat.finalResourceCost = LegalBRACosts[i][1];
	  mat.coins = LegalCoins[i% LegalCoins.length];
	  mat.matNumber = (i % 7) + 1;
	  mat.bonusCoins = (i % 9) + 1;
	  mat.bonusPop = (i % 7) + 1;
	  
		String imageStr = PlayerMatImageServlet.playerMatToSting(mat);
		String encodedStr = "PlayerMatImages/" + DatatypeConverter.printBase64Binary(imageStr.getBytes()) + ".png";
		%>
		<p><img src="<%= encodedStr %>" alt="A Random PlayerMat" height="400" width="1024"></p>
		<% 		
  }

%>

</body>
</html>