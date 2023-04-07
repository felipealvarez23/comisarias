const path = require("path");
const rootDir = path.join(__dirname);

module.exports = {
  preset: "jest-preset-angular",
  setupFilesAfterEnv: ["<rootDir>/setup.jest.js"],
  watchPlugins: [
    "jest-watch-typeahead/filename",
    "jest-watch-typeahead/testname",
  ],
  transformIgnorePatterns: [
    "node_modules/(?!.*\\.mjs$|@ngrx|ngx-socket-io|ngx-auto-unsubscribe|rxjs)"
  ],
  testPathIgnorePatterns: [
    "<rootDir>/node_modules/",
    "<rootDir>/dist/",
    '<rootDir>/acceptancetest/'
  ],
  collectCoverage: true,
  coverageDirectory: path.join(`${rootDir}`, '/coverage/'),
  coverageReporters: ["html", "json", "lcov", "text", "clover"],
  reporters: [
    "default",
    ["jest-junit", { outputDirectory: "./coverage/", outputName: "junit.xml" }],
    ["jest-html-reporters", { publicPath: "./coverage/", filename: "report-jest.html" }],
    "jest-sonar"
  ]
};
