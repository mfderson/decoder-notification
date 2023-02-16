package com.ead.notification.configs

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean

@Bean
fun modelMapper() = ModelMapper()