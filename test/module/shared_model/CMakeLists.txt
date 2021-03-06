# Copyright Soramitsu Co., Ltd. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

add_subdirectory(backend_proto)
add_subdirectory(bindings)
add_subdirectory(converters)
add_subdirectory(builders)
add_subdirectory(validators)
add_subdirectory(cryptography)

AddTest(reference_holder_test
    reference_holder_test.cpp
    )
target_link_libraries(reference_holder_test
    boost
    )

AddTest(interface_test
    interface_test.cpp
    )
target_link_libraries(interface_test
    shared_model_default_builders
    logger
    )

add_library(commands_mocks_factory
    mock_objects_factories/mock_command_factory.cpp
    )
target_link_libraries(commands_mocks_factory
    shared_model_interfaces
    shared_model_proto_backend
    logger
    gtest::main
    gmock::main
    )
