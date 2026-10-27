Pod::Spec.new do |s|
  s.name             = 'APIVerveMoonriseMoonset'
  s.version          = '1.2.3'
  s.summary          = 'Moonrise Moonset calculates exact moonrise and moonset times for any geographic coordinate.'
  s.description      = <<-'DESC'
Moonrise Moonset calculates exact moonrise and moonset times for any geographic coordinate. It outputs ISO 8601 timestamps for lunar rise and set events, with paid plans adding moon phase details and date selection.

This iOS/macOS SDK provides a convenient way to access the Moonrise Moonset from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/moonrisemoonset?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/moonrisemoonset-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveMoonriseMoonset/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
