<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="css/style2.css">
</head>
<body>
<div class="div1">
    <form action="verifstock"   method="post">
       <table class="table0">
           <tr>
             <td> Produit : </td>
             <td><input type="text" name="motclé"  /></td>
             <td><input type="submit" value="Search" name="verificationstock"  /></td>
              <td><table>
                <tr>
                <td>
                <a    href="produit" style="margin-left: 310px; font-family: fantasy; ">  Page operation Client</a> 
                </td>
                </tr>
              
             </table></td>
             <td><table>
                <tr>
                <td>
                <a  href="quantite" style="margin-left: 360px; font-family: fantasy;">Ajouter Produit</a>
                </td>
                </tr>
              
             </table></td>
           </tr>  
           
       </table>
    </form>
      <form action="verifstock"   method="post">
      <table class="table3">
         <tr>
            <th>Reference</th><th>Produit</th>
         </tr>
         <tr>
              <td> <input  type="text" name="refpstock" ></td>
              <td> <input  type="text" name="produitstock" ></td>
              <td> <input  hidden="" type="text" name="qttstock" value="0"></td>
         </tr>
         <tr>
         <td 	><input  type="submit"  name="verificationstock" value="Ajouter" ></td>
         </tr>
      </table>
       </form>
</div>
<div class="div01">

     <table class="table1">
          <tr>
                  <th>REF-PROD</th><th>Nom Produit</th><th>Quantité </th>
          </tr>
          <c:forEach   items="${model.verifstock }"  var="vs">
          <c:if test="${vs.reference!='' }">
          <tr>
                   
                   <td> ${vs.reference }</td>
                   <td> ${vs.produit }</td>
                   <td> ${vs.quantite }</td>
          </tr></c:if>
          </c:forEach>
     </table>
</div>
</body>
</html>