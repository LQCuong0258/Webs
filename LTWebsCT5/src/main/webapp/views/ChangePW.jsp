<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="main">
	<div class="container">

		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-9">
			<h1>Forgot Your Password?</h1>
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
					<form action="/LTWebsCT5/ChangePW" method="post">
							<div class="form-group">
								<label for="password" class="col-lg-4 control-label">New password</label>
								<div class="col-lg-8">
									<input type="password" class="form-control" name="npassword" id="npassword">
									</br>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-lg-4 control-label">Confirm password</label>
								<div class="col-lg-8">
									<input type="password" class="form-control" name="confirm-password" id="confirm-password">
								</br>
								</div>
							</div>
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
									<button type="submit" class="btn btn-primary">OK</button>
								</div>
							</div>
							<div class="row">
						<div class="col-lg-8 col-md-offset-4 padding-left-0">
							</br>
							<a>${alert}</a>
						</div>
					</div>
						</form>
					</div>
					<div class="col-md-4 col-sm-4 pull-right">
						<div class="form-info">
							<h2>
								<em>Important</em> Information
							</h2>
							<p>Enter the e-mail address associated with your account.
								Click submit to have your password e-mailed to you.</p>

							<button type="button" class="btn btn-default">More
								details</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
</div>
</br>