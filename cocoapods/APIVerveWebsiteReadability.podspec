Pod::Spec.new do |s|
  s.name             = 'APIVerveWebsiteReadability'
  s.version          = '1.2.3'
  s.summary          = 'Website Readability analyzes live web pages to score their reading difficulty and educational grade level.'
  s.description      = <<-'DESC'
Website Readability analyzes live web pages to score their reading difficulty and educational grade level. It returns Flesch Reading Ease, Flesch-Kincaid grade level, word count, sentence count, and estimated reading time.

This iOS/macOS SDK provides a convenient way to access the Website Readability from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/websitereadability?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/websitereadability-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveWebsiteReadability/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
