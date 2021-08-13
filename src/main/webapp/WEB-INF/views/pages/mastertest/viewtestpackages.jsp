<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="box box-danger">
		<div class="box-header with-border">
			<h3 class="box-title">
				<b>View Test Packages</b>
			</h3>
			<div class="box-tools pull-right">
			</div>
		</div>
		
		<div class="box-body">
			<div class="row">
			<div class="box-body">
			<div class="form-group col-sm-12">
				<table class="table table-bordered">
				  <thead style="background-color:#ddd;" class="thead-light">
				    <tr>
				      <th scope="col" width="20%">Package Name</th>
				      <th scope="col">Test Names</th>
				      <th scope="col" width="5%">Discount</th>
				      <th scope="col" width="8%">Total Amt</th>
				      <th scope="col" width="8%">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<tr>
				      <td>Whole body check up</td>
				      <td>
				      AMA	ANTI MICROSOMAL ANTIBODY (ANTI TPO), ALP	ALKALINE PHOSPHATASE, 
				      ALB	ALBUMIN (BROMOCRESOL GREEN), AHEVM	ANTI HEV - IGM, 
				      AHAVM	ANTI HAV IGM, SERUM, AHAVG	ANTI HAV IGG, SERUM, 
				      AFP	ALPHA FETO PROTEIN, ADAN	ADENOSINE DEAMINASE, 
				      ACLM	ANTI-CARDIOLIPIN ANTIBODY - IGM,SERUM, ACLG	ANTI-CARDIOLIPIN ANTIBODY - IGG, 
				      AMA	ANTI MICROSOMAL ANTIBODY (ANTI TPO), ALP	ALKALINE PHOSPHATASE, 
				      ALB	ALBUMIN (BROMOCRESOL GREEN), AHEVM	ANTI HEV - IGM, 
				      AHAVM	ANTI HAV IGM, SERUM, AHAVG	ANTI HAV IGG, SERUM, 
				      AFP	ALPHA FETO PROTEIN, ADAN	ADENOSINE DEAMINASE, 
				      ACLM	ANTI-CARDIOLIPIN ANTIBODY - IGM,SERUM, ACLG	ANTI-CARDIOLIPIN ANTIBODY - IGG
				      </td>
				      <td>10%</td>
				      <td>10000</td>
				      <td>
					      <div class="box-tools pull-center">
							<a href="#">
								<button type="button"
									class="btn btn-sm btn-info btn-box-tool"
									onclick="testNameEdit('${testName.testId}','${testName.groupId}','${testName.testcode}','${testName.name}','${testName.description}','${testName.price}','${testName.b2bprice}')">
										<i class="fa fa-edit" style="color: white"></i>
								</button> 
							</a> 
							<button type="button" class="btn btn-xs btn-toggle active" data-toggle="button" aria-pressed="true">
		    					<div class="handle"></div>
		  					</button>
						</div>
					</td>
				    </tr>
				    <tr>
				      <td>Basic cardiac health check up</td>
				      <td>
				      AMA	ANTI MICROSOMAL ANTIBODY (ANTI TPO), ALP	ALKALINE PHOSPHATASE, 
				      ALB	ALBUMIN (BROMOCRESOL GREEN), AHEVM	ANTI HEV - IGM, 
				      AHAVM	ANTI HAV IGM, SERUM, AHAVG	ANTI HAV IGG, SERUM, 
				      AFP	ALPHA FETO PROTEIN, ADAN	ADENOSINE DEAMINASE, 
				      ACLM	ANTI-CARDIOLIPIN ANTIBODY - IGM,SERUM, ACLG	ANTI-CARDIOLIPIN ANTIBODY - IGG
				      </td>
				      <td>0%</td>
				      <td>5000</td>
				      <td>
					      <div class="box-tools pull-center">
							<a href="#">
								<button type="button"
									class="btn btn-sm btn-info btn-box-tool"
									onclick="testNameEdit('${testName.testId}','${testName.groupId}','${testName.testcode}','${testName.name}','${testName.description}','${testName.price}','${testName.b2bprice}')">
										<i class="fa fa-edit" style="color: white"></i>
								</button> 
							</a> 
							<button type="button" class="btn btn-xs btn-toggle active" data-toggle="button" aria-pressed="true">
		    					<div class="handle"></div>
		  					</button>
						</div>
					</td>
				    </tr>
				    <tr>
				      <td>General Test</td>
				      <td>
				      AMA	ANTI MICROSOMAL ANTIBODY (ANTI TPO), ALP	ALKALINE PHOSPHATASE, 
				      ALB	ALBUMIN (BROMOCRESOL GREEN), AHEVM	ANTI HEV - IGM, 
				      AHAVM	ANTI HAV IGM, SERUM, AHAVG	ANTI HAV IGG, SERUM, 
				      AFP	ALPHA FETO PROTEIN, ADAN	ADENOSINE DEAMINASE, 
				      ACLM	ANTI-CARDIOLIPIN ANTIBODY - IGM,SERUM, ACLG	ANTI-CARDIOLIPIN ANTIBODY - IGG
				      </td>
				      <td>20%</td>
				      <td>8000</td>
				      <td>
					      <div class="box-tools pull-center">
							<a href="#">
								<button type="button"
									class="btn btn-sm btn-info btn-box-tool"
									onclick="testNameEdit('${testName.testId}','${testName.groupId}','${testName.testcode}','${testName.name}','${testName.description}','${testName.price}','${testName.b2bprice}')">
										<i class="fa fa-edit" style="color: white"></i>
								</button> 
							</a> 
							<button type="button" class="btn btn-xs btn-toggle active" data-toggle="button" aria-pressed="true">
		    					<div class="handle"></div>
		  					</button>
						</div>
					</td>
				    </tr>
				    <tr>
				      <td>Whole body check up</td>
				      <td>
				      AMA	ANTI MICROSOMAL ANTIBODY (ANTI TPO), ALP	ALKALINE PHOSPHATASE, 
				      ALB	ALBUMIN (BROMOCRESOL GREEN), AHEVM	ANTI HEV - IGM, 
				      AHAVM	ANTI HAV IGM, SERUM, AHAVG	ANTI HAV IGG, SERUM, 
				      AFP	ALPHA FETO PROTEIN, ADAN	ADENOSINE DEAMINASE, 
				      ACLM	ANTI-CARDIOLIPIN ANTIBODY - IGM,SERUM, ACLG	ANTI-CARDIOLIPIN ANTIBODY - IGG, 
				      AMA	ANTI MICROSOMAL ANTIBODY (ANTI TPO), ALP	ALKALINE PHOSPHATASE, 
				      ALB	ALBUMIN (BROMOCRESOL GREEN), AHEVM	ANTI HEV - IGM, 
				      AHAVM	ANTI HAV IGM, SERUM, AHAVG	ANTI HAV IGG, SERUM, 
				      AFP	ALPHA FETO PROTEIN, ADAN	ADENOSINE DEAMINASE, 
				      ACLM	ANTI-CARDIOLIPIN ANTIBODY - IGM,SERUM, ACLG	ANTI-CARDIOLIPIN ANTIBODY - IGG
				      </td>
				      <td>10%</td>
				      <td>10000</td>
				      <td>
					      <div class="box-tools pull-center">
							<a href="#">
								<button type="button"
									class="btn btn-sm btn-info btn-box-tool"
									onclick="testNameEdit('${testName.testId}','${testName.groupId}','${testName.testcode}','${testName.name}','${testName.description}','${testName.price}','${testName.b2bprice}')">
										<i class="fa fa-edit" style="color: white"></i>
								</button> 
							</a> 
							<button type="button" class="btn btn-xs btn-toggle active" data-toggle="button" aria-pressed="true">
		    					<div class="handle"></div>
		  					</button>
						</div>
					</td>
				    </tr>
				  </tbody>
				</table>
				</div>
			</div>
		</div>
	</div>
</div>	
</section>

