<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="main">
	<div class="container">
	
	
	<!-- BEGIN SIDEBAR -->
          <div class="sidebar col-md-3 col-sm-3">
            <ul class="list-group margin-bottom-25 sidebar-menu">
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Login/Register</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Restore Password</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> My account</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Address book</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Wish list</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Returns</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Newsletter</a></li>
            </ul>
          </div>
          <!-- END SIDEBAR -->
	
	
		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-9">
			<h1>Create an account</h1>
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
						<form action="/LTWebsCT5/SignUp" method="post">
							<fieldset>
								<legend>Your personal account</legend>
								<div class="form-group">
									<label for="username" class="col-lg-4 control-label">User
										Name <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" name="username"
											id="username">
											</br>
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-lg-4 control-label">Email
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" name="email"
											id="email">
											</br>
									</div>
								</div>
							</fieldset>
							<fieldset>
								<legend>Your password</legend>
								<div class="form-group">
									<label for="password" class="col-lg-4 control-label">Password
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="password" class="form-control" name="password"
											id="password">
											</br>
									</div>
								</div>
								<div class="form-group">
									<label for="confirm-password" class="col-lg-4 control-label">Confirm
										password <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="password" class="form-control"
											name="confirm-password" id="confirm-password">
											</br>
									</div>
								</div>
							</fieldset>
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Create
										an account</button>
									<button type="button" class="btn btn-default" onclick="window.location.href='/LTWebsCT5/views/Login.jsp'" >Cancel</button>
									
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
							<p>Lorem ipsum dolor ut sit ame dolore adipiscing elit, sed
								sit nonumy nibh sed euismod ut laoreet dolore magna aliquarm
								erat sit volutpat. Nostrud exerci tation ullamcorper suscipit
								lobortis nisl aliquip commodo quat.</p>

							<p>Duis autem vel eum iriure at dolor vulputate velit esse
								vel molestie at dolore.</p>

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