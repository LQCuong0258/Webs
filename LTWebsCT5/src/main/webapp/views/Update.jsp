<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="main">
<div class="container">

<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
	<h1>PROFILE</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form action="/LTWebsCT5/multiPartServlet" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="fullname" class="col-lg-4 control-label">Full name <span
							class="require">*</span></label>
						<div class="col-lg-8">
							<input type="text" class="form-control" name="fullname" id="fullname">
							</br>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-lg-4 control-label">Phone
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" name="phone" id="phone">
							</br>
						</div>
					</div>
					
					<div class="form-group">
						<label for="image" class="col-lg-4 control-label">Choose a file	</label>
						<div class="col-lg-8">
							<input type="file" name="multiPartServlet"/>
						</div>
					</div>

					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
					</div>
					
					<div class="form-group">
						<form> ${message} </form>
					</div>
					
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Duis autem vel eum iriure at dolor vulputate velit esse vel
						molestie at dolore.</p>

					<button type="button" class="btn btn-default">More details</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->
</div>
</div>
</br>