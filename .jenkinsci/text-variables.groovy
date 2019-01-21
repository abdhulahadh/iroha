param_chose_opt = 'Default\nBranch commit\nOn open PR\nCommit in Open PR\nBefore merge to trunk\nBefore merge develop\nBefore merge master\nNightly build\nCustom command'

param_descriptions = """
<p>
  <strong>Default</strong> - will automatically chose the correct one based on branch name and build number<br />
  <strong>Branch commit</strong> - Linux/gcc v5; Test: Smoke, Unit;<br />
  <strong>On open PR -</strong> Linux/gcc v5, MacOS/appleclang; Test: Smoke, Unit; Coverage; Analysis: cppcheck, sonar;<br />
  <strong>Commit in Open PR</strong> - Same as Branch commit<br />
  <strong>Before merge to trunk</strong> - Linux/gcc v5 v7, Linux/clang v6 v7, MacOS/appleclang; Test: ALL; Coverage; Analysis: cppcheck, sonar; Build type: Debug when Release<br />
  <strong>Before merge develop</strong> - Not implemented<br />
  <strong>Before merge master</strong> - Not implemented<br />
  <strong>Nightly build</strong> - Not implemented<br />
  <strong>Custom command</strong> - enter command below, Ex: build_type='Release'; testing=false;<br />
</p>
"""

cmd_description = """
<h3>List of parameters for Jenkins "Custom command" option:</h3>
<div>
<ul>
<li>
<p><strong>&lt;option_name&gt;</strong> = &lt;default_value&gt; [(or &lt;second_default_value&gt; if &lt;git branch name&gt;)]&nbsp;</p>
<ul>
<li>
<p>&lt;descriptions&gt;</p>
</li>
<li>
<p>Ex: &lt;Example of Use&gt;</p>
</li>
</ul>
</li>
</ul>
</div>
<ul>
<li>
<p><strong>x64linux_compiler_list</strong> = ['gcc5']&nbsp;</p>
<ul>
<li>
<p>Linux compiler name to build</p>
</li>
<li>
<p>Ex:&nbsp;x64linux_compiler_list = ['gcc5','gcc7', 'clang6' , 'clang7']</p>
</li>
</ul>
</li>
<li>
<p><strong>mac_compiler_list</strong> = [ ]&nbsp;</p>
<ul>
<li>
<p>Mac compiler name to build</p>
</li>
<li>
<p>Ex:&nbsp;mac_compiler_list = ['appleclang']</p>
</li>
</ul>
</li>
</ul>
<ul>
<li>
<p><strong>parallelism</strong> = 0</p>
<ul>
<li>
<p>Build in parallel. 0 is choose default: 8 for Linux and 4 for Mac</p>
</li>
<li>Ex:&nbsp;cppcheck = flase</li>
</ul>
</li>
</ul>
<ul>
<li>
<p><strong>testing</strong> = true&nbsp;</p>
<ul>
<li>
<p>Run test for each selected compiler, in jenkins will be several reports</p>
</li>
<li>Ex:&nbsp;cppcheck = flase</li>
</ul>
</li>
<li>
<p><strong>testList</strong> = '(module)'&nbsp;</p>
<ul>
<li>
<p>Test Regex name</p>
</li>
<li>
<p>Ex:&nbsp;testList = '()'-All,&nbsp;testList = '(module|integration|system|cmake|regression|benchmark|framework)'</p>
</li>
</ul>
</li>
<li>
<p><strong>sanitize</strong> = false&nbsp;</p>
<ul>
<li>
<p>Adds cmakeOptions&nbsp;-DSANITIZE='address;leak'&nbsp;</p>
</li>
<li>
<p>Ex:&nbsp;sanitize=true;</p>
</li>
</ul>
</li>
<li>
<p><strong>cppcheck</strong> = false</p>
<ul>
<li>
<p>Runs&nbsp;cppcheck&nbsp;</p>
</li>
<li>
<p>Ex:&nbsp;cppcheck = true</p>
</li>
</ul>
</li>
<li>
<p><span style="color: #ff0000;"><strong>fuzzing</strong></span> = false&nbsp;</p>
<ul>
<li>
<p>builds fuzzing tests, work only with&nbsp;x64linux_compiler_list = ['clang6']&nbsp;</p>
</li>
<li>
<p>Ex:&nbsp;fuzzing=true; x64linux_compiler_list= ['clang6']; testing = true; testList = "(None)"</p>
</li>
</ul>
</li>
<li>
<p><span style="color: #ff0000;"><strong>sonar</strong></span> = false&nbsp;</p>
<ul>
<li>
<p>Runs Sonar Analysis, runs only on Linux</p>
</li>
<li>
<p>Ex:&nbsp;sonar = true;x64linux_compiler_list= ['gcc5','gcc7']</p>
</li>
</ul>
</li>
<li>
<p><span style="color: #ff0000;"><strong>coverage</strong></span> = false&nbsp;</p>
<ul>
<li>
<p>Runs coverage, will run only if&nbsp;testing = true&nbsp;</p>
</li>
<li>
<p>Ex:&nbsp;coverage = true</p>
</li>
</ul>
</li>
<li>
<p><strong>doxygen</strong> = false (or = true if master|develop|dev )&nbsp;</p>
<ul>
<li>
<p>Build doxygen, if specialBranch== true will publish, if not specialBranch will upload it to jenkins,</p>
</li>
<li>
<p>Ex:&nbsp;doxygen=true</p>
</li>
</ul>
</li>
<li>
<p><strong>build_type</strong> = 'Debug'&nbsp;</p>
<ul>
<li>
<p>Sets&nbsp;-DCMAKE_BUILD_TYPE=Debug&nbsp;</p>
</li>
<li>
<p>Ex:&nbsp;build_type = 'Release';packageBuild = true;testing=false</p>
</li>
</ul>
</li>
<li>
<p><span style="color: #ff0000;"><strong>packageBuild</strong></span> = false&nbsp;</p>
<ul>
<li>
<p>Build package Work only with&nbsp;build_type = 'Release'&nbsp;and&nbsp;testing=false&nbsp;</p>
</li>
<li>
<p>Ex:&nbsp;packageBuild = true;build_type = 'Release';testing=false</p>
</li>
</ul>
</li>
<li>
<p><strong>pushDockerTag</strong> = 'not-supposed-to-be-pushed'(or = latest if master, or = develop if develop|dev)&nbsp;-</p>
<ul>
<li>
<p>if&nbsp;packagePush=true&nbsp;it the name of docker tag that will be pushed</p>
</li>
<li>
<p>Ex:&nbsp;packageBuild = true;build_type = 'Release';testing=false;packagePush=true</p>
</li>
</ul>
</li>
<li>
<p><strong>packagePush</strong> = false (or = true if master|develop|dev )&nbsp;-</p>
<ul>
<li>
<p>push all packages and docker to the artifactory and docker hub</p>
</li>
<li>
<p>Ex:packagePush=true;packageBuild = true;build_type = 'Release';testing=false</p>
</li>
</ul>
</li>
<li>
<p><strong>specialBranch</strong> = false (or = true if master|develop|dev ),</p>
<ul>
<li>
<p>Not recommended to set, it used to decide push&nbsp;doxygen&nbsp;and&nbsp;iroha:develop-build&nbsp;or not, and force to run&nbsp;build_type = 'Release'</p>
</li>
</ul>
</li>
</ul>
<p><span style="color: #ff0000;"><strong>Red&nbsp;</strong></span>- this options require to set additional options, or may conflict with another options&nbsp;</p>
"""

return this