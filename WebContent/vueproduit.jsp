
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-type"  content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="css/style0.css">
<script type="text/javascript">
        function confirmer(url) {         repense= confirm(" Suprimer!!  ") ;  
                            if(repense==true){document.location=url;} }
        function confirmer1(url) {         repense= confirm(" Confiramtion ") ;  
        if(repense==true){document.location=url;} }
</script>
</head>
<body> 
<div class="div1">

    <form action="produit"   method="post">
    
       <table class="table0">
           <tr>
             <td> Chercher : </td>
             <td><input type="text" name="motclé"  /></td>
             <td><input type="submit" value="Search" name="action"  /></td>
             <td><table>
                <tr>
                <td>
                <a  href="quantite" style="margin-left: 310px;  font-family: fantasy;">Ajouter Produit</a>
                </td>
                </tr>
             </table></td>
             <td><table>
                <tr>
                <td>
                <a  href="verifstock" style="margin-left: 360px;  font-family: fantasy;"> Vérifier le Stock</a>
                </td>
                </tr>
              
             </table></td>
             </tr>
       </table>
    </form>
      <form action="produit"   method="post">
      <table class="table3">
       <tr>
         <th>Client</th><th>Reference</th><th>Produit</th><th>PRIX Unité</th><th>Quantité</th>
       </tr>
       <tr>   
              <td> <input  type="text" name="client" value="Client" ></td>
              <td> <input  type="text" name="reference" ></td>
              <td> <input  type="text" name="designation" ></td>
              <td> <input  type="text" name="prix" ></td>
              <td> <input  type="text" name="quantite" ></td>
       </tr>
       <tr>
         <td 	><input  type="submit"  name="action" value="Ajouter" ></td>
         <td>${model.errors }</td>
      </tr>
      </table>
      
       </form>
   </div>
   
         <c:forEach   items="${model.verifstock }"  var="vs">
        <table > <tr><td>La quantité de ce Produit dans le stocks est :  ${vs.quantite } <td></tr></table></c:forEach>
        <form action="produit"   method="post"><input  type="submit" name="action" value="aficher les operation non confirmer "></form>
        <form action="produit"   method="post"><input  type="submit" name="action" value="statistique "></form>
          
<div class="div01">

     <table class="table1">
          <tr>
                 <th>Client</th> <th>REF-PROD</th><th>Nom Produit</th><th>PRIX</th><th>QUANTITE</th><th>PRIX TOTAL</th><th>La Date</th>
          </tr>
          <c:forEach   items="${model.produit }"  var="p" >
          <tr>
                   <td hidden="" ><output  name="id" > ${p.id }</output>  </td>
                   <td>${p.clientname }</td>
                   <td> ${p.refproduit }</td>
                   <td> ${p.designation }</td>
                   <td> ${p.prix }</td>
                   <td> ${p.quantité }</td>
                   <td> ${p.quantité*p.prix}</td>
                   <td hidden=""> ${p.confirmation}</td>
                   <td>${p.date}</td>
              
                   
               <c:if test="${p.confirmation==null}">  
                  <td> <a  href="javascript:confirmer('produit?action=suprimer&id=${p.id}')"> 
                   <button style="border-bottom-color:gray;outline-color: black; outline-style:groove; "  > Suprimer</button></a></td>
                  <td> <a  href="javascript:confirmer1('produit?action=Valider&id=${p.id}')"> 
                   <button  style="border-bottom-color:gray;outline-color: black; outline-style:groove; "  > Valider</button> </a></td>
               </c:if>
           </tr>        
          </c:forEach>
          
     </table>
</div>
 
</body>
<table class="table4"><tr><td>By:</td></tr>
            <tr><td class="td2">YOUSSEF AOUINTY</td></tr>
            <tr><td class="td3">YOUNES BOURJA</td></tr>
<tr></table>
</html>