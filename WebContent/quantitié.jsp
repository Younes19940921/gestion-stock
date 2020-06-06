<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="css/style1.css">
</head>
<body>
<div class="div1">
    <form action="quantite"   method="post">
       <table class="table0">
           <tr>
             <td> Nom produit : </td>
             <td><input type="text" name="motclé"  /></td>
             <td><input type="submit" value="Search" name="stock"  /></td>
              <td>
              <table>
                <tr>
                <td>
                <a  href="produit" style="margin-left: 290px; font-family: fantasy;   ">  Page operation Client</a>
                </td>
                </tr>
              
             </table></td>
             <td><table>
                <tr>
                <td>
                <a  href="verifstock" style="margin-left: 310px; font-family: fantasy; "> Vérifier le Stock</a>
                </td>
                </tr>
              
             </table></td>
           </tr>  
           
       </table>
    </form>
      <form action="quantite"   method="post">
      <table class="table3">
         <tr>
            <th>Reference</th><th>Produit</th><th>Quantité Entrer</th>
         </tr>
         <tr>
              <td> <input  type="text" name="refpstock" ></td>
              <td> <input  type="text" name="produitstock" ></td>
              <td> <input  type="text" name="qttentrer" ></td>
         </tr>
         <tr>
         <td 	><input  type="submit"  name="stock" value="Ajouter" ></td>
          <td>${model.errors }</td>
         </tr>
      </table>  </form>
</div>
 <c:forEach   items="${model.verifstock }"  var="vs">
        <table > <tr><td>La quantité de ce Produit dans le stocks est :  ${vs.quantite } <td></tr></table></c:forEach>
<div class="div01">

     <table class="table1">
          <tr>
                  <th>REF-PROD</th><th>Nom Produit</th><th>Quantité Enter</th><th>Date Entrer</th>
          </tr>
          <c:forEach   items="${model.stock }"  var="s">
          <tr>
                   
                   <td> ${s.refence }</td>
                   <td> ${s.produit }</td>
                   <td> ${s.qttenter }</td>
                   <td>${s.date}</td>
          </tr>
          </c:forEach>
     </table>
</div>
</body>
</html>