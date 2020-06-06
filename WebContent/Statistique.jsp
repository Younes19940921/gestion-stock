<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


    <form   action="statistique"  method="post">
       <table >
          <tr>
             <td>le ref:</td>
             <td><input   type="text" name="ref" ></td>
          </tr>
           <tr>
             <td> la date:</td>
             <td><input   type="text" name="date"></td>
          </tr>
        <tr>
           <td><input type="submit" name="cherche"  value="checher" ></td>
          </tr></table></form>
         
         
      <table>
        <c:forEach  items="${model.Stat}"  var="st">
         <tr> 
               <td>  ${st.reference}   </td>
               <td>  ${st.produit}   </td>
               <td>  ${st.quantité}   </td>
               <td>  ${st.date}   </td>
 
          </tr>
          </c:forEach>
   </table>

   
 
 
</body>
</html>