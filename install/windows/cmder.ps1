cinst cmder -y

Install-PackageProvider NuGet -MinimumVersion '2.8.5.201' -Force
Set-PSRepository -Name PSGallery -InstallationPolicy Trusted
Install-Module -Name 'oh-my-posh'
Install-Module -Name 'Get-ChildItemColor' -AllowClobber

ise $PROFILE